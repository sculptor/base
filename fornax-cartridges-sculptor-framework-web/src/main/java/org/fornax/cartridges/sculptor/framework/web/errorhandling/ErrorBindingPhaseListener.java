/*
 * Copyright 2008 The Fornax Project Team, including the original 
 * author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.framework.web.errorhandling;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

/**
 * Gets the {@link Errors} object from validator classes and creates a
 * FacesMessage for each error message in that object.
 * <p>
 * The Errors object holds error codes which are resolved using i18n.messages
 * <p>
 * If the error belongs to a field (i.e., it's a {@link FieldError}), the field
 * name is prepended to the error message.
 * <p>
 * If the error code cannot be resolved, the default message of the
 * {@link ObjectError} is used instead.
 *
 */
public class ErrorBindingPhaseListener implements PhaseListener, MessageSourceAware {

	private MessageSource messageSource;
	
	/** 
	 * Pull out the Spring Errors object from context and convert each error into
	 * a FacesMessage.
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		RequestContext requestContext = RequestContextHolder.getRequestContext();
		
		if (requestContext==null)
			return;
		Map model;
		try {
			model = requestContext.getFlashScope().asMap();
		} catch (IllegalStateException e) {
			return;
		}
		Locale locale = context.getExternalContext().getRequestLocale();

		for (Iterator iter = model.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			Object value = model.get(key);
			
			// If we have an Errors object and it is not the duplicate currentFormObject
			// one (always provided for compatibility with single object forms)
			if (value instanceof Errors && !key.endsWith("currentFormObject")) {
				Errors errors = (Errors) value;

				for (Iterator eter = errors.getAllErrors().iterator(); eter.hasNext();) {
					ObjectError error = (ObjectError) eter.next();
					String summary = null;
					try {
						ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages",context.getViewRoot().getLocale());
	                    summary = bundle.getString(error.getCode());
	                
	                    /* another way of getting the error code resolved */
		                /* it might be better to use this one */
		                /*FacesContext fc = FacesContext.getCurrentInstance();
		                ELContext elc = fc.getELContext();
		                ExpressionFactory ef = fc.getApplication().getExpressionFactory();
		                ValueExpression ve = ef.createValueExpression(elc, "#{msg}", PropertyResourceBundle.class);
		                PropertyResourceBundle msg = (PropertyResourceBundle) ve.getValue(elc);
		                if (msg != null) {
		                	summary = msg.getString(error.getCode());
		                }*/
		                
	                    summary = MessageFormat.format(summary, error.getArguments());
	                    
	                    // if it's a field error we prepend the name of the field to the message
	                    if (error instanceof FieldError) {
							FieldError fieldError = (FieldError) error;
							summary = fieldError.getField() + " - " + summary;
						}
	                } catch (MissingResourceException mrexception) {
	                	summary = error.getDefaultMessage();
						// try to translate the message
						if (messageSource!=null) {
							summary = messageSource.getMessage(error, locale);
						}
						if (summary != null) {
							summary = MessageFormat.format(summary, error.getArguments());
						}
	                }
	                
	                if (summary != null) {
						String detail = summary;
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
						context.addMessage(null, message);
	                }
				}
			}
		}
	}

	/** 
	 * Do nothing.
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	public void beforePhase(PhaseEvent event) {
		// do nothing
	}

	/** 
	 * The intent is to catch validation errors added by a controller
	 * so we need to intercept after the application phase of the 
	 * lifecycle, but before rendering.
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	public PhaseId getPhaseId() {
		return PhaseId.INVOKE_APPLICATION;
	}

	/**
	 * Provide message source for converting error messages.
	 * @param messageSource
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}