/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.BasicType;
import sculptormetamodel.CommandEvent;
import sculptormetamodel.Consumer;
import sculptormetamodel.DataTransferObject;
import sculptormetamodel.DomainEvent;
import sculptormetamodel.DomainObject;
import sculptormetamodel.DomainObjectOperation;
import sculptormetamodel.DomainObjectTypedElement;
import sculptormetamodel.Entity;
import sculptormetamodel.EnumConstructorParameter;
import sculptormetamodel.EnumValue;
import sculptormetamodel.Event;
import sculptormetamodel.Inheritance;
import sculptormetamodel.Module;
import sculptormetamodel.NamedElement;
import sculptormetamodel.Operation;
import sculptormetamodel.Parameter;
import sculptormetamodel.Publish;
import sculptormetamodel.Reference;
import sculptormetamodel.Repository;
import sculptormetamodel.RepositoryOperation;
import sculptormetamodel.Resource;
import sculptormetamodel.ResourceOperation;
import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;
import sculptormetamodel.Subscribe;
import sculptormetamodel.Trait;
import sculptormetamodel.TypedElement;
import sculptormetamodel.ValueObject;
import sculptormetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see sculptormetamodel.SculptormetamodelPackage
 * @generated
 */
public class SculptormetamodelSwitch {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static SculptormetamodelPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptormetamodelSwitch() {
        if (modelPackage == null) {
            modelPackage = SculptormetamodelPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public Object doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch((EClass)eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected Object doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case SculptormetamodelPackage.NAMED_ELEMENT: {
                NamedElement namedElement = (NamedElement)theEObject;
                Object result = caseNamedElement(namedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.APPLICATION: {
                Application application = (Application)theEObject;
                Object result = caseApplication(application);
                if (result == null) result = caseNamedElement(application);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.SERVICE: {
                Service service = (Service)theEObject;
                Object result = caseService(service);
                if (result == null) result = caseNamedElement(service);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.REPOSITORY: {
                Repository repository = (Repository)theEObject;
                Object result = caseRepository(repository);
                if (result == null) result = caseNamedElement(repository);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.DOMAIN_OBJECT: {
                DomainObject domainObject = (DomainObject)theEObject;
                Object result = caseDomainObject(domainObject);
                if (result == null) result = caseNamedElement(domainObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.REFERENCE: {
                Reference reference = (Reference)theEObject;
                Object result = caseReference(reference);
                if (result == null) result = caseNamedElement(reference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.TYPED_ELEMENT: {
                TypedElement typedElement = (TypedElement)theEObject;
                Object result = caseTypedElement(typedElement);
                if (result == null) result = caseNamedElement(typedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.DOMAIN_OBJECT_TYPED_ELEMENT: {
                DomainObjectTypedElement domainObjectTypedElement = (DomainObjectTypedElement)theEObject;
                Object result = caseDomainObjectTypedElement(domainObjectTypedElement);
                if (result == null) result = caseTypedElement(domainObjectTypedElement);
                if (result == null) result = caseNamedElement(domainObjectTypedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.ATTRIBUTE: {
                Attribute attribute = (Attribute)theEObject;
                Object result = caseAttribute(attribute);
                if (result == null) result = caseTypedElement(attribute);
                if (result == null) result = caseNamedElement(attribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.OPERATION: {
                Operation operation = (Operation)theEObject;
                Object result = caseOperation(operation);
                if (result == null) result = caseDomainObjectTypedElement(operation);
                if (result == null) result = caseTypedElement(operation);
                if (result == null) result = caseNamedElement(operation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.PARAMETER: {
                Parameter parameter = (Parameter)theEObject;
                Object result = caseParameter(parameter);
                if (result == null) result = caseDomainObjectTypedElement(parameter);
                if (result == null) result = caseTypedElement(parameter);
                if (result == null) result = caseNamedElement(parameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.REPOSITORY_OPERATION: {
                RepositoryOperation repositoryOperation = (RepositoryOperation)theEObject;
                Object result = caseRepositoryOperation(repositoryOperation);
                if (result == null) result = caseOperation(repositoryOperation);
                if (result == null) result = caseDomainObjectTypedElement(repositoryOperation);
                if (result == null) result = caseTypedElement(repositoryOperation);
                if (result == null) result = caseNamedElement(repositoryOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.SERVICE_OPERATION: {
                ServiceOperation serviceOperation = (ServiceOperation)theEObject;
                Object result = caseServiceOperation(serviceOperation);
                if (result == null) result = caseOperation(serviceOperation);
                if (result == null) result = caseDomainObjectTypedElement(serviceOperation);
                if (result == null) result = caseTypedElement(serviceOperation);
                if (result == null) result = caseNamedElement(serviceOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.VALUE_OBJECT: {
                ValueObject valueObject = (ValueObject)theEObject;
                Object result = caseValueObject(valueObject);
                if (result == null) result = caseDomainObject(valueObject);
                if (result == null) result = caseNamedElement(valueObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.ENTITY: {
                Entity entity = (Entity)theEObject;
                Object result = caseEntity(entity);
                if (result == null) result = caseDomainObject(entity);
                if (result == null) result = caseNamedElement(entity);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.MODULE: {
                Module module = (Module)theEObject;
                Object result = caseModule(module);
                if (result == null) result = caseNamedElement(module);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.BASIC_TYPE: {
                BasicType basicType = (BasicType)theEObject;
                Object result = caseBasicType(basicType);
                if (result == null) result = caseValueObject(basicType);
                if (result == null) result = caseDomainObject(basicType);
                if (result == null) result = caseNamedElement(basicType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.CONSUMER: {
                Consumer consumer = (Consumer)theEObject;
                Object result = caseConsumer(consumer);
                if (result == null) result = caseNamedElement(consumer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.ENUM: {
                sculptormetamodel.Enum enum_ = (sculptormetamodel.Enum)theEObject;
                Object result = caseEnum(enum_);
                if (result == null) result = caseDomainObject(enum_);
                if (result == null) result = caseNamedElement(enum_);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.ENUM_VALUE: {
                EnumValue enumValue = (EnumValue)theEObject;
                Object result = caseEnumValue(enumValue);
                if (result == null) result = caseNamedElement(enumValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.ENUM_CONSTRUCTOR_PARAMETER: {
                EnumConstructorParameter enumConstructorParameter = (EnumConstructorParameter)theEObject;
                Object result = caseEnumConstructorParameter(enumConstructorParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.INHERITANCE: {
                Inheritance inheritance = (Inheritance)theEObject;
                Object result = caseInheritance(inheritance);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.DATA_TRANSFER_OBJECT: {
                DataTransferObject dataTransferObject = (DataTransferObject)theEObject;
                Object result = caseDataTransferObject(dataTransferObject);
                if (result == null) result = caseValueObject(dataTransferObject);
                if (result == null) result = caseDomainObject(dataTransferObject);
                if (result == null) result = caseNamedElement(dataTransferObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.COMMAND_EVENT: {
                CommandEvent commandEvent = (CommandEvent)theEObject;
                Object result = caseCommandEvent(commandEvent);
                if (result == null) result = caseEvent(commandEvent);
                if (result == null) result = caseValueObject(commandEvent);
                if (result == null) result = caseDomainObject(commandEvent);
                if (result == null) result = caseNamedElement(commandEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.DOMAIN_EVENT: {
                DomainEvent domainEvent = (DomainEvent)theEObject;
                Object result = caseDomainEvent(domainEvent);
                if (result == null) result = caseEvent(domainEvent);
                if (result == null) result = caseValueObject(domainEvent);
                if (result == null) result = caseDomainObject(domainEvent);
                if (result == null) result = caseNamedElement(domainEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.SUBSCRIBE: {
                Subscribe subscribe = (Subscribe)theEObject;
                Object result = caseSubscribe(subscribe);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.EVENT: {
                Event event = (Event)theEObject;
                Object result = caseEvent(event);
                if (result == null) result = caseValueObject(event);
                if (result == null) result = caseDomainObject(event);
                if (result == null) result = caseNamedElement(event);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.PUBLISH: {
                Publish publish = (Publish)theEObject;
                Object result = casePublish(publish);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.TRAIT: {
                Trait trait = (Trait)theEObject;
                Object result = caseTrait(trait);
                if (result == null) result = caseDomainObject(trait);
                if (result == null) result = caseNamedElement(trait);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.DOMAIN_OBJECT_OPERATION: {
                DomainObjectOperation domainObjectOperation = (DomainObjectOperation)theEObject;
                Object result = caseDomainObjectOperation(domainObjectOperation);
                if (result == null) result = caseOperation(domainObjectOperation);
                if (result == null) result = caseDomainObjectTypedElement(domainObjectOperation);
                if (result == null) result = caseTypedElement(domainObjectOperation);
                if (result == null) result = caseNamedElement(domainObjectOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.RESOURCE: {
                Resource resource = (Resource)theEObject;
                Object result = caseResource(resource);
                if (result == null) result = caseNamedElement(resource);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SculptormetamodelPackage.RESOURCE_OPERATION: {
                ResourceOperation resourceOperation = (ResourceOperation)theEObject;
                Object result = caseResourceOperation(resourceOperation);
                if (result == null) result = caseOperation(resourceOperation);
                if (result == null) result = caseDomainObjectTypedElement(resourceOperation);
                if (result == null) result = caseTypedElement(resourceOperation);
                if (result == null) result = caseNamedElement(resourceOperation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseApplication(Application object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseService(Service object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseRepository(Repository object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Domain Object</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Domain Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseDomainObject(DomainObject object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseReference(Reference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseTypedElement(TypedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Domain Object Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Domain Object Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseDomainObjectTypedElement(DomainObjectTypedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseAttribute(Attribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseOperation(Operation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseParameter(Parameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Repository Operation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Repository Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseRepositoryOperation(RepositoryOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service Operation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseServiceOperation(ServiceOperation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Object</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseValueObject(ValueObject object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseEntity(Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseModule(Module object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Basic Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Basic Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseBasicType(BasicType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consumer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consumer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseConsumer(Consumer object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enum</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseEnum(sculptormetamodel.Enum object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>Enum Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseEnumValue(EnumValue object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>Enum Constructor Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Constructor Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public Object caseEnumConstructorParameter(EnumConstructorParameter object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>Inheritance</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Inheritance</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseInheritance(Inheritance object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Data Transfer Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Transfer Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDataTransferObject(DataTransferObject object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Command Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Command Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseCommandEvent(CommandEvent object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Domain Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Domain Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDomainEvent(DomainEvent object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Subscribe</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Subscribe</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSubscribe(Subscribe object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseEvent(Event object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Publish</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Publish</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePublish(Publish object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Trait</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trait</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseTrait(Trait object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Domain Object Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Domain Object Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDomainObjectOperation(DomainObjectOperation object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseResource(Resource object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Operation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseResourceOperation(ResourceOperation object) {
        return null;
    }

                /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public Object defaultCase(EObject object) {
        return null;
    }

} //SculptormetamodelSwitch
