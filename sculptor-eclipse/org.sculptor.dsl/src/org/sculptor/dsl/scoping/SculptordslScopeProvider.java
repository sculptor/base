/*
 * Copyright 2013 The Sculptor Project Team, including the original 
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
package org.sculptor.dsl.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.sculptor.dsl.sculptordsl.DslDomainObject;
import org.sculptor.dsl.sculptordsl.DslOppositeHolder;
import org.sculptor.dsl.sculptordsl.DslReference;
import org.sculptor.dsl.sculptordsl.DslRepository;
import org.sculptor.dsl.sculptordsl.DslRepositoryOperation;
import org.sculptor.dsl.sculptordsl.DslResourceOperationDelegate;
import org.sculptor.dsl.sculptordsl.DslService;
import org.sculptor.dsl.sculptordsl.DslServiceOperation;
import org.sculptor.dsl.sculptordsl.DslServiceOperationDelegate;
import org.sculptor.dsl.sculptordsl.DslServiceRepositoryOption;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
public class SculptordslScopeProvider extends AbstractDeclarativeScopeProvider {

    IScope scope_DslOppositeHolder_opposite(DslOppositeHolder ctx, EReference ref) {
        Scope scope =  new Scope();
        List<IEObjectDescription> elements = new ArrayList<IEObjectDescription>();
        scope.setElements(elements);
        DslDomainObject domainObject = (DslDomainObject) ((DslReference) ctx.eContainer()).getDomainObjectType();
        List<DslReference> references = domainObject.getReferences();
        for (DslReference reference : references) {
            if (reference.eContainer() != null) {
                elements.add(new EObjectDescription(QualifiedName.create(reference.getName()), reference, null));
            }
        }
        return scope;
    }

    IScope scope_DslServiceOperationDelegate_delegateOperation(DslServiceOperationDelegate ctx, EReference ref) {
        Scope scope =  new Scope();
        List<IEObjectDescription> elements = new ArrayList<IEObjectDescription>();
        DslServiceRepositoryOption option = ctx.getDelegate();
        if (option != null) {
            if (option instanceof DslRepository) {
                List<DslRepositoryOperation> operations = ((DslRepository) option).getOperations();
                for (DslRepositoryOperation operation : operations) {
                    elements.add(new EObjectDescription(QualifiedName.create(operation.getName()), operation, null));
                }
            } else {
                List<DslServiceOperation> operations = ((DslService) option).getOperations();
                for (DslServiceOperation operation : operations) {
                    elements.add(new EObjectDescription(QualifiedName.create(operation.getName()), operation, null));
                }
            }
        }
        scope.setElements(elements);
        return scope;
    }

    IScope scope_DslResourceOperationDelegate_delegateOperation(DslResourceOperationDelegate ctx, EReference ref) {
        Scope scope = new Scope();
        List<IEObjectDescription> elements = new ArrayList<IEObjectDescription>();
        DslService option = ctx.getDelegate();
        if (option != null) {
            List<DslServiceOperation> operations = (option).getOperations();
            for (DslServiceOperation operation : operations) {
                elements.add(new EObjectDescription(QualifiedName.create(operation.getName()), operation, null));
            }
        }
        scope.setElements(elements);
        return scope;
    }

    IScope scope_DslReference2_domainObjectType(DslReference ctx, EReference ref) {
        IScope scope = super.getScope(ctx, ref);
        // List<IEObjectDescription> elements = new
        // ArrayList<IEObjectDescription>();

        // scope.setElements(elements);
        return scope;
    }
}
