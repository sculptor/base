/*
 * Copyright 2007 The Fornax Project Team, including the original
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

package org.fornax.cartridges.sculptor.generator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import sculptorguimetamodel.AttributeViewProperty;
import sculptorguimetamodel.BasicTypeViewProperty;
import sculptorguimetamodel.DerivedReferenceViewProperty;
import sculptorguimetamodel.EnumViewProperty;
import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.ReferenceViewProperty;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.UserTaskGroup;
import sculptorguimetamodel.ViewDataProperty;
import sculptorguimetamodel.impl.SculptorguimetamodelFactoryImpl;
import sculptormetamodel.Attribute;
import sculptormetamodel.BasicType;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Parameter;
import sculptormetamodel.Reference;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;

/**
 * Utilities for gui code generation and transformation. It is used from oAW
 * templates and transformations via oAW extensions.
 *
 */
@SuppressWarnings("unchecked")
public class GuiGenerationHelper {

	public static String getWebPackage(GuiModule guiModule) {
        return getClientPackage(guiModule, GeneratorProperties.getWebPackage());
    }

	public static String getRichClientPackage(GuiModule guiModule) {
	    return getClientPackage(guiModule, GeneratorProperties.getRichClientPackage());
    }

	private static String getClientPackage(GuiModule guiModule, String subPackage) {
        String base = guiModule.getBasePackage();
        if (base == null) {
            base = guiModule.getApplication().getBasePackage();
            if (guiModule.getName() != null && !guiModule.getName().equals("")) {
                base += "." + guiModule.getName();
            }
            base += "." + subPackage;
        }
        return base;
    }

	public static String getRichClientPackage(GuiApplication guiApp) {
	    return guiApp.getBasePackage() + "." + GeneratorProperties.getRichClientPackage();
	}

	public static String getWebRoot(GuiApplication guiApplication) {
		String root = guiApplication.getBasePackage();
		if (root == null) {
			root = guiApplication.getName().toLowerCase();
		}
		int pos;
		if ((pos = root.lastIndexOf('.')) != -1) {
			root = root.substring(pos+1);
		}
		root += "-web";
		return root;
	}

	public static boolean isServiceAvailable(DomainObject domainObject) {
		return getService(domainObject) != null;
	}

	public static ServiceOperation getSaveMethod(DomainObject domainObject) {
		return getMethod(domainObject, "save", false);
	}

	public static ServiceOperation getFindByIdMethod(DomainObject domainObject) {
		return getMethod(domainObject, "findById", false);
	}

	public static ServiceOperation getFindAllMethod(DomainObject domainObject) {
		return getMethod(domainObject, "findAll", true);
	}

	public static ServiceOperation getDeleteMethod(DomainObject domainObject) {
		return getMethod(domainObject, "delete", false);
	}

	public static ServiceOperation getPopulateAssociationsMethod(DomainObject domainObject) {
        return getMethod(domainObject, "populateAssociations", false);
    }

	public static Service getService(DomainObject domainObject) {
		Collection<Service> moduleServices = domainObject
				.getModule().getServices();
		if (moduleServices == null) {
			return null;
		}
		String domainObjectServiceName = domainObject.getName() + "Service";
		for (Service service : moduleServices) {
			if (service.getName().equals(domainObjectServiceName)) {
				return service;
			}
		}

		// not found
		if (domainObject.getExtends() == null) {
		    return null;
		} else {
		    // recursive call
		    return getService(domainObject.getExtends());
		}
	}

	private static ServiceOperation getMethod(DomainObject domainObject,
			String methodName,
            boolean lookForPagingParameter) {
		Service service = getService(domainObject);
		if (service == null) {
			return null;
		}
		ServiceOperation result = null;
        if (lookForPagingParameter) {
            result = getMethod(service, methodName, true);
        }
        if (result == null) {
            result = getMethod(service, methodName, false);
        }
		if (result != null) {
		    return result;
		} else if (domainObject.getExtends() == null) {
		    // not found
		    return null;
		} else {
		    // recursive call
            return getMethod(domainObject.getExtends(), methodName, lookForPagingParameter);
		}
	}

	private static ServiceOperation getMethod(Service service, String methodName, boolean lookForPagingParameter) {
		for (ServiceOperation sp : (List<ServiceOperation>) service.getOperations()) {
			if (sp.getName().equals(methodName) && (!lookForPagingParameter || hasPagingParameter(sp))) {
				return sp;
			}
		}
		// not found
		return null;
	}

    private static boolean hasPagingParameter(ServiceOperation op) {
        for (Parameter each : (Iterable<Parameter>) op.getParameters()) {
            if ("PagingParameter".equals(each.getType())) {
                return true;
            }
        }
        return false;
    }

	public static Collection<String> getRequiredFieldsForUpdate(
			DomainObject domainObject) {
		ArrayList<String> requiredFields = new ArrayList<String>();
		for (Attribute att : (Collection<Attribute>) domainObject
				.getAttributes()) {
			if (att.isChangeable() && !att.isNullable()
					&& !isSystemAttribute(att)) {
				requiredFields.add(att.getName());
			}
		}
		for (Reference ref : (Collection<Reference>) domainObject
				.getReferences()) {
			if (ref.getTo() instanceof BasicType) {
				for (Attribute att : (Collection<Attribute>) ref.getTo()
						.getAttributes()) {
					if (att.isChangeable() && !att.isNullable()
							&& !isSystemAttribute(att)) {
						requiredFields.add(ref.getName()
								+ GenerationHelper.toFirstUpper(att.getName()));
					}
				}
			}
		}
		return requiredFields;
	}

	public static Collection<String> getRequiredFieldsForCreate(
			DomainObject domainObject) {
		ArrayList<String> requiredFields = new ArrayList<String>();
		for (Attribute att : (Collection<Attribute>) domainObject
				.getAttributes()) {
			if (!att.isNullable() && !isSystemAttribute(att)) {
				requiredFields.add(att.getName());
			}
		}
		for (Reference ref : (Collection<Reference>) domainObject
				.getReferences()) {
			if (ref.getTo() instanceof BasicType) {
				for (Attribute att : (Collection<Attribute>) ref.getTo()
						.getAttributes()) {
					if (!att.isNullable() && !isSystemAttribute(att)) {
						requiredFields.add(ref.getName()
								+ GenerationHelper.toFirstUpper(att.getName()));
					}
				}
			}
			if (ref.getTo() instanceof sculptormetamodel.Enum) {
				if (!ref.isNullable()) {
					requiredFields.add(ref.getName());
				}
			}
		}
		return requiredFields;
	}

	private static boolean isSystemAttribute(Attribute att) {
		String[] systemAttributes = GeneratorProperties.getProperty(
				"systemAttributes").split(",");
		for (int i = 0; i < systemAttributes.length; i++) {
			if (systemAttributes[i].equals(att.getName())) {
				return true;
			}
		}
		return false;
	}

	public static String uncapitalizeSecondaryWords(String text) {
		if (text == null || text.length() <= 2 || !text.contains(" ")) {
			return text;
		}
		String[] words = text.split(" ");
		for (int i = 1; i < words.length; i++) {
			String w = words[i];
			if (w.trim().equals("")) {
				continue;
			}
			if (Character.isUpperCase(w.charAt(0))
					&& (w.length() == 1 || Character.isLowerCase(w.charAt(1)))) {
				words[i] = GenerationHelper.toFirstLower(w);
			}
		}

		StringBuffer sb = new StringBuffer(text.length());
		for (int i = 0; i < words.length; i++) {
			if (i != 0) {
				sb.append(" ");
			}
			sb.append(words[i]);
		}

		return sb.toString();

	}

	public static List<ViewDataProperty> filterReferences(
			final List<ViewDataProperty> props) {
		Set<DomainObject> bench = new HashSet<DomainObject>();
		List<ViewDataProperty> filteredList = new ArrayList<ViewDataProperty>();
		for (ViewDataProperty prop : props) {
			if (prop instanceof ReferenceViewProperty) {

				ReferenceViewProperty refProp = (ReferenceViewProperty) prop;
				if (refProp.getTarget().getExtends() != null) {
					if (!bench.contains(refProp.getTarget().getExtends())) {
						bench.add(refProp.getTarget().getExtends());
						filteredList.add(prop);
					}
				} else {
					filteredList.add(prop);
				}
			} else {
				filteredList.add(prop);
			}

		}
		return filteredList;
	}

	public static List<ReferenceViewProperty> filterReferenceTargets(
			final List<ReferenceViewProperty> props) {
		Set<DomainObject> bench = new HashSet<DomainObject>();
		List<ReferenceViewProperty> filteredList = new ArrayList<ReferenceViewProperty>();
		for (ReferenceViewProperty prop : props) {
			if (prop.getTarget() != null) {
				if (!bench.contains(prop.getTarget())) {
					bench.add(prop.getTarget());
					filteredList.add(prop);
				}
			}
		}
		return filteredList;
	}

	public static List<ReferenceViewProperty> referencePropertiesWithAdditionlBaseReferenceProperties(
			final List<ReferenceViewProperty> props) {
		ArrayList<ReferenceViewProperty> newList = new ArrayList<ReferenceViewProperty>();
		Set<DomainObject> bench = new HashSet<DomainObject>();
		for (ReferenceViewProperty prop : props) {
			newList.add(prop);
			if (prop.getTarget().getExtends() != null) {
				if (!bench.contains(prop.getTarget().getExtends())) {
					bench.add(prop.getTarget().getExtends());
					ReferenceViewProperty baseProp = SculptorguimetamodelFactoryImpl.eINSTANCE
							.createReferenceViewProperty();
					baseProp.setName(prop.getName());
					baseProp.setTarget(prop.getTarget().getExtends());
					baseProp.setReference(prop.getReference());
					// baseProp.setUserTask(prop.getUserTask());
					newList.add(baseProp);
				}
			}
		}
		return newList;
	}

	/**
	 * @param props
	 * @return
	 */
	public static List<ReferenceViewProperty> createParentProperties(
			final List<ReferenceViewProperty> props) {
		ArrayList<ReferenceViewProperty> newList = new ArrayList<ReferenceViewProperty>();
		Set<DomainObject> parents = new HashSet<DomainObject>();
		for (ReferenceViewProperty prop : props) {
			if (prop.getTarget().getExtends() != null) {
				if (!parents.contains(prop.getTarget().getExtends())) {
					parents.add(prop.getTarget().getExtends());
					ReferenceViewProperty baseProp = SculptorguimetamodelFactoryImpl.eINSTANCE
							.createReferenceViewProperty();
					baseProp.setName(prop.getName());
					baseProp.setTarget(prop.getTarget().getExtends());
					baseProp.setReference(prop.getReference());
					// baseProp.setUserTask(prop.getUserTask());
					newList.add(baseProp);

				}
			}
		}
		return newList;
	}

	public static List<UserTaskGroup> groupByTarget(List<UserTask> tasks) {
		return groupedBy(tasks, new UserTaskGroupSpecification() {
			public Object groupingObject(UserTask task) {
				return task.getFor();
			}

			public boolean include(UserTask task) {
				return true; // all
			}
		});
	}

	public static List<UserTaskGroup> menuTasksGroupedByTarget(List<UserTask> tasks) {
		return groupedBy(tasks, new UserTaskGroupSpecification() {
			public Object groupingObject(UserTask task) {
				return task.getFor();
			}

			public boolean include(UserTask task) {
				return task.isConversationRoot();
			}
		});
	}


	private static List<UserTaskGroup> groupedBy(List<UserTask> tasks, UserTaskGroupSpecification spec) {
		// preserv order by using LinkedHashMap
		LinkedHashMap<Object, UserTaskGroup> groupBy = new LinkedHashMap<Object, UserTaskGroup>();
		for (UserTask t : tasks) {
			if (!spec.include(t)) {
				continue;
			}
			UserTaskGroup group = groupBy.get(spec.groupingObject(t));
			if (group == null) {
				group = SculptorguimetamodelFactoryImpl.eINSTANCE.createUserTaskGroup();
				group.setFor(t.getFor());
				group.setModule(t.getModule());
				groupBy.put(spec.groupingObject(t), group);
			}
			group.getUserTasks().add(t);
		}

		return new ArrayList<UserTaskGroup>(groupBy.values());
	}

	interface UserTaskGroupSpecification {
		boolean include(UserTask task);
		Object groupingObject(UserTask task);
	}

	public static List<ViewDataProperty> filterViewProperties(List<ViewDataProperty> props) {
		Set<Object> bench = new HashSet<Object>();
		List<ViewDataProperty> filteredList = new ArrayList<ViewDataProperty>();
		for (ViewDataProperty prop : props) {
			Object filterObj = filterViewPropertyByObject(prop);
			if (!bench.contains(filterObj)) {
				bench.add(filterObj);
				filteredList.add(prop);
			}
		}
		return filteredList;
	}

	private static Object filterViewPropertyByObject(ViewDataProperty prop) {
	    if (prop instanceof DerivedReferenceViewProperty) {
	        return new DerivedReferenceViewPropertyFilterObj(
	                (DerivedReferenceViewProperty) prop);
	    } else if (prop instanceof ReferenceViewProperty) {
			return ((ReferenceViewProperty) prop).getReference();
		} else if (prop instanceof AttributeViewProperty) {
			return ((AttributeViewProperty) prop).getAttribute();
		} else if (prop instanceof BasicTypeViewProperty) {
			return ((BasicTypeViewProperty) prop).getAttribute();
		} else if (prop instanceof EnumViewProperty) {
			return ((EnumViewProperty) prop).getReference();
		} else {
			return prop;
		}
	}

	private static class DerivedReferenceViewPropertyFilterObj {
	    private final DerivedReferenceViewProperty prop;

        public DerivedReferenceViewPropertyFilterObj(DerivedReferenceViewProperty prop) {
            this.prop = prop;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + prop.getReference().hashCode();
            result = prime * result + prop.getTarget().hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            DerivedReferenceViewPropertyFilterObj other = (DerivedReferenceViewPropertyFilterObj) obj;

            return prop.getReference().equals(other.prop.getReference()) &&
                prop.getTarget().equals(other.prop.getTarget());
        }




	}


}

