/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see sculptormetamodel.SculptormetamodelPackage
 * @generated
 */
public class SculptormetamodelAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static SculptormetamodelPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptormetamodelAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SculptormetamodelPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SculptormetamodelSwitch modelSwitch =
        new SculptormetamodelSwitch() {
            public Object caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            public Object caseApplication(Application object) {
                return createApplicationAdapter();
            }
            public Object caseService(Service object) {
                return createServiceAdapter();
            }
            public Object caseRepository(Repository object) {
                return createRepositoryAdapter();
            }
            public Object caseDomainObject(DomainObject object) {
                return createDomainObjectAdapter();
            }
            public Object caseReference(Reference object) {
                return createReferenceAdapter();
            }
            public Object caseTypedElement(TypedElement object) {
                return createTypedElementAdapter();
            }
            public Object caseDomainObjectTypedElement(DomainObjectTypedElement object) {
                return createDomainObjectTypedElementAdapter();
            }
            public Object caseAttribute(Attribute object) {
                return createAttributeAdapter();
            }
            public Object caseOperation(Operation object) {
                return createOperationAdapter();
            }
            public Object caseParameter(Parameter object) {
                return createParameterAdapter();
            }
            public Object caseRepositoryOperation(RepositoryOperation object) {
                return createRepositoryOperationAdapter();
            }
            public Object caseServiceOperation(ServiceOperation object) {
                return createServiceOperationAdapter();
            }
            public Object caseValueObject(ValueObject object) {
                return createValueObjectAdapter();
            }
            public Object caseEntity(Entity object) {
                return createEntityAdapter();
            }
            public Object caseModule(Module object) {
                return createModuleAdapter();
            }
            public Object caseBasicType(BasicType object) {
                return createBasicTypeAdapter();
            }
            public Object caseConsumer(Consumer object) {
                return createConsumerAdapter();
            }
            public Object caseEnum(sculptormetamodel.Enum object) {
                return createEnumAdapter();
            }
            public Object caseEnumValue(EnumValue object) {
                return createEnumValueAdapter();
            }
            public Object caseEnumConstructorParameter(EnumConstructorParameter object) {
                return createEnumConstructorParameterAdapter();
            }
            public Object caseInheritance(Inheritance object) {
                return createInheritanceAdapter();
            }
            public Object caseDataTransferObject(DataTransferObject object) {
                return createDataTransferObjectAdapter();
            }
            public Object caseCommandEvent(CommandEvent object) {
                return createCommandEventAdapter();
            }
            public Object caseDomainEvent(DomainEvent object) {
                return createDomainEventAdapter();
            }
            public Object caseSubscribe(Subscribe object) {
                return createSubscribeAdapter();
            }
            public Object caseEvent(Event object) {
                return createEventAdapter();
            }
            public Object casePublish(Publish object) {
                return createPublishAdapter();
            }
            public Object caseTrait(Trait object) {
                return createTraitAdapter();
            }
            public Object caseDomainObjectOperation(DomainObjectOperation object) {
                return createDomainObjectOperationAdapter();
            }
            public Object caseResource(Resource object) {
                return createResourceAdapter();
            }
            public Object caseResourceOperation(ResourceOperation object) {
                return createResourceOperationAdapter();
            }
            public Object defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	public Adapter createAdapter(Notifier target) {
        return (Adapter)modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.NamedElement
     * @generated
     */
	public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Application
     * @generated
     */
	public Adapter createApplicationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Service <em>Service</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Service
     * @generated
     */
	public Adapter createServiceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Repository <em>Repository</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Repository
     * @generated
     */
	public Adapter createRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.DomainObject <em>Domain Object</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.DomainObject
     * @generated
     */
	public Adapter createDomainObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Reference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Reference
     * @generated
     */
	public Adapter createReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.TypedElement
     * @generated
     */
	public Adapter createTypedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.DomainObjectTypedElement <em>Domain Object Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.DomainObjectTypedElement
     * @generated
     */
	public Adapter createDomainObjectTypedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Attribute
     * @generated
     */
	public Adapter createAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Operation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Operation
     * @generated
     */
	public Adapter createOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Parameter
     * @generated
     */
	public Adapter createParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.RepositoryOperation <em>Repository Operation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.RepositoryOperation
     * @generated
     */
	public Adapter createRepositoryOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.ServiceOperation <em>Service Operation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.ServiceOperation
     * @generated
     */
	public Adapter createServiceOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.ValueObject <em>Value Object</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.ValueObject
     * @generated
     */
	public Adapter createValueObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Entity <em>Entity</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Entity
     * @generated
     */
	public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Module <em>Module</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Module
     * @generated
     */
	public Adapter createModuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.BasicType <em>Basic Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.BasicType
     * @generated
     */
	public Adapter createBasicTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Consumer <em>Consumer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Consumer
     * @generated
     */
    public Adapter createConsumerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Enum <em>Enum</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Enum
     * @generated
     */
	public Adapter createEnumAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.EnumValue <em>Enum Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.EnumValue
     * @generated
     */
	public Adapter createEnumValueAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.EnumConstructorParameter <em>Enum Constructor Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.EnumConstructorParameter
     * @generated
     */
	public Adapter createEnumConstructorParameterAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Inheritance <em>Inheritance</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Inheritance
     * @generated
     */
    public Adapter createInheritanceAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.DataTransferObject <em>Data Transfer Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.DataTransferObject
     * @generated
     */
    public Adapter createDataTransferObjectAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.CommandEvent <em>Command Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.CommandEvent
     * @generated
     */
    public Adapter createCommandEventAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.DomainEvent <em>Domain Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.DomainEvent
     * @generated
     */
    public Adapter createDomainEventAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Subscribe <em>Subscribe</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Subscribe
     * @generated
     */
    public Adapter createSubscribeAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Event <em>Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Event
     * @generated
     */
    public Adapter createEventAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Publish <em>Publish</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Publish
     * @generated
     */
    public Adapter createPublishAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Trait <em>Trait</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Trait
     * @generated
     */
    public Adapter createTraitAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.DomainObjectOperation <em>Domain Object Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.DomainObjectOperation
     * @generated
     */
    public Adapter createDomainObjectOperationAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.Resource <em>Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.Resource
     * @generated
     */
    public Adapter createResourceAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for an object of class '{@link sculptormetamodel.ResourceOperation <em>Resource Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see sculptormetamodel.ResourceOperation
     * @generated
     */
    public Adapter createResourceOperationAdapter() {
        return null;
    }

                /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //SculptormetamodelAdapterFactory
