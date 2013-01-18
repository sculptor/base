/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.BasicType;
import sculptormetamodel.CommandEvent;
import sculptormetamodel.Consumer;
import sculptormetamodel.DataTransferObject;
import sculptormetamodel.DiscriminatorType;
import sculptormetamodel.DomainEvent;
import sculptormetamodel.DomainObjectOperation;
import sculptormetamodel.DomainObjectTypedElement;
import sculptormetamodel.Entity;
import sculptormetamodel.EnumConstructorParameter;
import sculptormetamodel.EnumValue;
import sculptormetamodel.HttpMethod;
import sculptormetamodel.Inheritance;
import sculptormetamodel.InheritanceType;
import sculptormetamodel.Module;
import sculptormetamodel.Operation;
import sculptormetamodel.Parameter;
import sculptormetamodel.Publish;
import sculptormetamodel.Reference;
import sculptormetamodel.Repository;
import sculptormetamodel.RepositoryOperation;
import sculptormetamodel.Resource;
import sculptormetamodel.ResourceOperation;
import sculptormetamodel.SculptormetamodelFactory;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SculptormetamodelFactoryImpl extends EFactoryImpl implements SculptormetamodelFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SculptormetamodelFactory init() {
        try {
            SculptormetamodelFactory theSculptormetamodelFactory = (SculptormetamodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.fornax-platform.org/sculptor"); 
            if (theSculptormetamodelFactory != null) {
                return theSculptormetamodelFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SculptormetamodelFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptormetamodelFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case SculptormetamodelPackage.APPLICATION: return createApplication();
            case SculptormetamodelPackage.SERVICE: return createService();
            case SculptormetamodelPackage.REPOSITORY: return createRepository();
            case SculptormetamodelPackage.REFERENCE: return createReference();
            case SculptormetamodelPackage.TYPED_ELEMENT: return createTypedElement();
            case SculptormetamodelPackage.DOMAIN_OBJECT_TYPED_ELEMENT: return createDomainObjectTypedElement();
            case SculptormetamodelPackage.ATTRIBUTE: return createAttribute();
            case SculptormetamodelPackage.OPERATION: return createOperation();
            case SculptormetamodelPackage.PARAMETER: return createParameter();
            case SculptormetamodelPackage.REPOSITORY_OPERATION: return createRepositoryOperation();
            case SculptormetamodelPackage.SERVICE_OPERATION: return createServiceOperation();
            case SculptormetamodelPackage.VALUE_OBJECT: return createValueObject();
            case SculptormetamodelPackage.ENTITY: return createEntity();
            case SculptormetamodelPackage.MODULE: return createModule();
            case SculptormetamodelPackage.BASIC_TYPE: return createBasicType();
            case SculptormetamodelPackage.CONSUMER: return createConsumer();
            case SculptormetamodelPackage.ENUM: return createEnum();
            case SculptormetamodelPackage.ENUM_VALUE: return createEnumValue();
            case SculptormetamodelPackage.ENUM_CONSTRUCTOR_PARAMETER: return createEnumConstructorParameter();
            case SculptormetamodelPackage.INHERITANCE: return createInheritance();
            case SculptormetamodelPackage.DATA_TRANSFER_OBJECT: return createDataTransferObject();
            case SculptormetamodelPackage.COMMAND_EVENT: return createCommandEvent();
            case SculptormetamodelPackage.DOMAIN_EVENT: return createDomainEvent();
            case SculptormetamodelPackage.SUBSCRIBE: return createSubscribe();
            case SculptormetamodelPackage.PUBLISH: return createPublish();
            case SculptormetamodelPackage.TRAIT: return createTrait();
            case SculptormetamodelPackage.DOMAIN_OBJECT_OPERATION: return createDomainObjectOperation();
            case SculptormetamodelPackage.RESOURCE: return createResource();
            case SculptormetamodelPackage.RESOURCE_OPERATION: return createResourceOperation();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case SculptormetamodelPackage.INHERITANCE_TYPE:
                return createInheritanceTypeFromString(eDataType, initialValue);
            case SculptormetamodelPackage.DISCRIMINATOR_TYPE:
                return createDiscriminatorTypeFromString(eDataType, initialValue);
            case SculptormetamodelPackage.HTTP_METHOD:
                return createHttpMethodFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case SculptormetamodelPackage.INHERITANCE_TYPE:
                return convertInheritanceTypeToString(eDataType, instanceValue);
            case SculptormetamodelPackage.DISCRIMINATOR_TYPE:
                return convertDiscriminatorTypeToString(eDataType, instanceValue);
            case SculptormetamodelPackage.HTTP_METHOD:
                return convertHttpMethodToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Application createApplication() {
        ApplicationImpl application = new ApplicationImpl();
        return application;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Service createService() {
        ServiceImpl service = new ServiceImpl();
        return service;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository createRepository() {
        RepositoryImpl repository = new RepositoryImpl();
        return repository;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference createReference() {
        ReferenceImpl reference = new ReferenceImpl();
        return reference;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypedElement createTypedElement() {
        TypedElementImpl typedElement = new TypedElementImpl();
        return typedElement;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObjectTypedElement createDomainObjectTypedElement() {
        DomainObjectTypedElementImpl domainObjectTypedElement = new DomainObjectTypedElementImpl();
        return domainObjectTypedElement;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Attribute createAttribute() {
        AttributeImpl attribute = new AttributeImpl();
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Operation createOperation() {
        OperationImpl operation = new OperationImpl();
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RepositoryOperation createRepositoryOperation() {
        RepositoryOperationImpl repositoryOperation = new RepositoryOperationImpl();
        return repositoryOperation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation createServiceOperation() {
        ServiceOperationImpl serviceOperation = new ServiceOperationImpl();
        return serviceOperation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueObject createValueObject() {
        ValueObjectImpl valueObject = new ValueObjectImpl();
        return valueObject;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Entity createEntity() {
        EntityImpl entity = new EntityImpl();
        return entity;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Module createModule() {
        ModuleImpl module = new ModuleImpl();
        return module;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BasicType createBasicType() {
        BasicTypeImpl basicType = new BasicTypeImpl();
        return basicType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Consumer createConsumer() {
        ConsumerImpl consumer = new ConsumerImpl();
        return consumer;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public sculptormetamodel.Enum createEnum() {
        EnumImpl enum_ = new EnumImpl();
        return enum_;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EnumValue createEnumValue() {
        EnumValueImpl enumValue = new EnumValueImpl();
        return enumValue;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EnumConstructorParameter createEnumConstructorParameter() {
        EnumConstructorParameterImpl enumConstructorParameter = new EnumConstructorParameterImpl();
        return enumConstructorParameter;
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Inheritance createInheritance() {
        InheritanceImpl inheritance = new InheritanceImpl();
        return inheritance;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataTransferObject createDataTransferObject() {
        DataTransferObjectImpl dataTransferObject = new DataTransferObjectImpl();
        return dataTransferObject;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommandEvent createCommandEvent() {
        CommandEventImpl commandEvent = new CommandEventImpl();
        return commandEvent;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainEvent createDomainEvent() {
        DomainEventImpl domainEvent = new DomainEventImpl();
        return domainEvent;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Subscribe createSubscribe() {
        SubscribeImpl subscribe = new SubscribeImpl();
        return subscribe;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Publish createPublish() {
        PublishImpl publish = new PublishImpl();
        return publish;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Trait createTrait() {
        TraitImpl trait = new TraitImpl();
        return trait;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObjectOperation createDomainObjectOperation() {
        DomainObjectOperationImpl domainObjectOperation = new DomainObjectOperationImpl();
        return domainObjectOperation;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Resource createResource() {
        ResourceImpl resource = new ResourceImpl();
        return resource;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceOperation createResourceOperation() {
        ResourceOperationImpl resourceOperation = new ResourceOperationImpl();
        return resourceOperation;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InheritanceType createInheritanceTypeFromString(EDataType eDataType, String initialValue) {
        InheritanceType result = InheritanceType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertInheritanceTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiscriminatorType createDiscriminatorTypeFromString(EDataType eDataType, String initialValue) {
        DiscriminatorType result = DiscriminatorType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDiscriminatorTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HttpMethod createHttpMethodFromString(EDataType eDataType, String initialValue) {
        HttpMethod result = HttpMethod.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertHttpMethodToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptormetamodelPackage getSculptormetamodelPackage() {
        return (SculptormetamodelPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	public static SculptormetamodelPackage getPackage() {
        return SculptormetamodelPackage.eINSTANCE;
    }

} //SculptormetamodelFactoryImpl
