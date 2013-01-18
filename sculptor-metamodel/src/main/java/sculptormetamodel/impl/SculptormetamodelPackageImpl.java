/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.BasicType;
import sculptormetamodel.CommandEvent;
import sculptormetamodel.Consumer;
import sculptormetamodel.DataTransferObject;
import sculptormetamodel.DiscriminatorType;
import sculptormetamodel.DomainEvent;
import sculptormetamodel.DomainObject;
import sculptormetamodel.DomainObjectOperation;
import sculptormetamodel.DomainObjectTypedElement;
import sculptormetamodel.Entity;
import sculptormetamodel.EnumConstructorParameter;
import sculptormetamodel.EnumValue;
import sculptormetamodel.Event;
import sculptormetamodel.HttpMethod;
import sculptormetamodel.Inheritance;
import sculptormetamodel.InheritanceType;
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
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;
import sculptormetamodel.Subscribe;
import sculptormetamodel.Trait;
import sculptormetamodel.TypedElement;
import sculptormetamodel.ValueObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SculptormetamodelPackageImpl extends EPackageImpl implements SculptormetamodelPackage {
    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass namedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass applicationEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass serviceEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass repositoryEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass domainObjectEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass referenceEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass domainObjectTypedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass operationEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass parameterEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass repositoryOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass serviceOperationEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass valueObjectEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass entityEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass moduleEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass basicTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass consumerEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass enumEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass enumValueEClass = null;

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass enumConstructorParameterEClass = null;

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inheritanceEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataTransferObjectEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass commandEventEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass domainEventEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subscribeEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass publishEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass traitEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass domainObjectOperationEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resourceOperationEClass = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum inheritanceTypeEEnum = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum discriminatorTypeEEnum = null;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum httpMethodEEnum = null;

                /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see sculptormetamodel.SculptormetamodelPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private SculptormetamodelPackageImpl() {
        super(eNS_URI, SculptormetamodelFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link SculptormetamodelPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static SculptormetamodelPackage init() {
        if (isInited) return (SculptormetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(SculptormetamodelPackage.eNS_URI);

        // Obtain or create and register package
        SculptormetamodelPackageImpl theSculptormetamodelPackage = (SculptormetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SculptormetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SculptormetamodelPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theSculptormetamodelPackage.createPackageContents();

        // Initialize created meta-data
        theSculptormetamodelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSculptormetamodelPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(SculptormetamodelPackage.eNS_URI, theSculptormetamodelPackage);
        return theSculptormetamodelPackage;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNamedElement() {
        return namedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNamedElement_Name() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamedElement_Doc() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamedElement_Hint() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getApplication() {
        return applicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getApplication_BasePackage() {
        return (EAttribute)applicationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getApplication_Modules() {
        return (EReference)applicationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getService() {
        return serviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getService_Operations() {
        return (EReference)serviceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getService_Module() {
        return (EReference)serviceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getService_OtherDependencies() {
        return (EAttribute)serviceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getService_ServiceDependencies() {
        return (EReference)serviceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getService_GapClass() {
        return (EAttribute)serviceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getService_WebService() {
        return (EAttribute)serviceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getService_RemoteInterface() {
        return (EAttribute)serviceEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getService_LocalInterface() {
        return (EAttribute)serviceEClass.getEStructuralFeatures().get(8);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getService_Subscribe() {
        return (EReference)serviceEClass.getEStructuralFeatures().get(9);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getService_RepositoryDependencies() {
        return (EReference)serviceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRepository() {
        return repositoryEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepository_Operations() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRepository_AggregateRoot() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRepository_RepositoryDependencies() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRepository_OtherDependencies() {
        return (EAttribute)repositoryEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRepository_GapClass() {
        return (EAttribute)repositoryEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRepository_Subscribe() {
        return (EReference)repositoryEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDomainObject() {
        return domainObjectEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDomainObject_References() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDomainObject_Extends() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDomainObject_Attributes() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDomainObject_Abstract() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDomainObject_Repository() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDomainObject_Module() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDomainObject_OptimisticLocking() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_Cache() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_Package() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_DatabaseTable() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_ExtendsName() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDomainObject_Validate() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(11);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_GapClass() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(12);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDomainObject_Inheritance() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(13);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_DiscriminatorColumnValue() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(14);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObject_AggregateRoot() {
        return (EAttribute)domainObjectEClass.getEStructuralFeatures().get(15);
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDomainObject_BelongsToAggregate() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(16);
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDomainObject_Operations() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(17);
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDomainObject_Traits() {
        return (EReference)domainObjectEClass.getEStructuralFeatures().get(18);
    }

                                                                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getReference() {
        return referenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_Many() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_CollectionType() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReference_Opposite() {
        return (EReference)referenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReference_To() {
        return (EReference)referenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_Cascade() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_OrderBy() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_Visibility() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_Changeable() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getReference_From() {
        return (EReference)referenceEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_Required() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_Fetch() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_Cache() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_NaturalKey() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_Inverse() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_Nullable() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_DatabaseColumn() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getReference_Validate() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(16);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_Transient() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(17);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_DatabaseJoinTable() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(18);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_DatabaseJoinColumn() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(19);
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypedElement() {
        return typedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTypedElement_Type() {
        return (EAttribute)typedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTypedElement_CollectionType() {
        return (EAttribute)typedElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTypedElement_MapKeyType() {
        return (EAttribute)typedElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDomainObjectTypedElement() {
        return domainObjectTypedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDomainObjectTypedElement_DomainObjectType() {
        return (EReference)domainObjectTypedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDomainObjectTypedElement_MapKeyDomainObjectType() {
        return (EReference)domainObjectTypedElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttribute() {
        return attributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_Changeable() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_DatabaseType() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_Nullable() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_NaturalKey() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_Visibility() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_Required() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttribute_Length() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttribute_Index() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttribute_DatabaseColumn() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttribute_Validate() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(9);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttribute_Transient() {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(10);
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOperation() {
        return operationEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperation_Throws() {
        return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperation_Visibility() {
        return (EAttribute)operationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperation_Parameters() {
        return (EReference)operationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperation_Publish() {
        return (EReference)operationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getParameter() {
        return parameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRepositoryOperation() {
        return repositoryOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRepositoryOperation_DelegateToAccessObject() {
        return (EAttribute)repositoryOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getRepositoryOperation_Repository() {
        return (EReference)repositoryOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRepositoryOperation_AccessObjectName() {
        return (EAttribute)repositoryOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getServiceOperation() {
        return serviceOperationEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getServiceOperation_Delegate() {
        return (EReference)serviceOperationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getServiceOperation_Service() {
        return (EReference)serviceOperationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getServiceOperation_ServiceDelegate() {
        return (EReference)serviceOperationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getValueObject() {
        return valueObjectEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValueObject_Immutable() {
        return (EAttribute)valueObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getValueObject_Persistent() {
        return (EAttribute)valueObjectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEntity() {
        return entityEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEntity_Auditable() {
        return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getModule() {
        return moduleEClass;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModule_BasePackage() {
        return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModule_Application() {
        return (EReference)moduleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModule_Services() {
        return (EReference)moduleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getModule_External() {
        return (EAttribute)moduleEClass.getEStructuralFeatures().get(5);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModule_PersistenceUnit() {
        return (EAttribute)moduleEClass.getEStructuralFeatures().get(6);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModule_Resources() {
        return (EReference)moduleEClass.getEStructuralFeatures().get(7);
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getModule_DomainObjects() {
        return (EReference)moduleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModule_Consumers() {
        return (EReference)moduleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBasicType() {
        return basicTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConsumer() {
        return consumerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConsumer_Module() {
        return (EReference)consumerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConsumer_RepositoryDependencies() {
        return (EReference)consumerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConsumer_ServiceDependencies() {
        return (EReference)consumerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConsumer_Channel() {
        return (EAttribute)consumerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConsumer_MessageRoot() {
        return (EReference)consumerEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConsumer_OtherDependencies() {
        return (EAttribute)consumerEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConsumer_Subscribe() {
        return (EReference)consumerEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEnum() {
        return enumEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEnum_Values() {
        return (EReference)enumEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEnum_Ordinal() {
        return (EAttribute)enumEClass.getEStructuralFeatures().get(1);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEnumValue() {
        return enumValueEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEnumValue_Parameters() {
        return (EReference)enumValueEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEnumConstructorParameter() {
        return enumConstructorParameterEClass;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEnumConstructorParameter_Value() {
        return (EAttribute)enumConstructorParameterEClass.getEStructuralFeatures().get(0);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInheritance() {
        return inheritanceEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInheritance_DiscriminatorColumnName() {
        return (EAttribute)inheritanceEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInheritance_DiscriminatorColumnLength() {
        return (EAttribute)inheritanceEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInheritance_Type() {
        return (EAttribute)inheritanceEClass.getEStructuralFeatures().get(2);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInheritance_DiscriminatorType() {
        return (EAttribute)inheritanceEClass.getEStructuralFeatures().get(3);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataTransferObject() {
        return dataTransferObjectEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCommandEvent() {
        return commandEventEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDomainEvent() {
        return domainEventEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubscribe() {
        return subscribeEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSubscribe_EventBus() {
        return (EAttribute)subscribeEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSubscribe_Topic() {
        return (EAttribute)subscribeEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEvent() {
        return eventEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPublish() {
        return publishEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPublish_EventBus() {
        return (EAttribute)publishEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPublish_Topic() {
        return (EAttribute)publishEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPublish_EventType() {
        return (EReference)publishEClass.getEStructuralFeatures().get(2);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTrait() {
        return traitEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDomainObjectOperation() {
        return domainObjectOperationEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDomainObjectOperation_DomainObject() {
        return (EReference)domainObjectOperationEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDomainObjectOperation_Abstract() {
        return (EAttribute)domainObjectOperationEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResource() {
        return resourceEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResource_ServiceDependencies() {
        return (EReference)resourceEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResource_GapClass() {
        return (EAttribute)resourceEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResource_Path() {
        return (EAttribute)resourceEClass.getEStructuralFeatures().get(2);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResource_Operations() {
        return (EReference)resourceEClass.getEStructuralFeatures().get(3);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResource_Module() {
        return (EReference)resourceEClass.getEStructuralFeatures().get(4);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResourceOperation() {
        return resourceOperationEClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceOperation_Resource() {
        return (EReference)resourceOperationEClass.getEStructuralFeatures().get(0);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResourceOperation_Path() {
        return (EAttribute)resourceOperationEClass.getEStructuralFeatures().get(1);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResourceOperation_HttpMethod() {
        return (EAttribute)resourceOperationEClass.getEStructuralFeatures().get(2);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getResourceOperation_Delegate() {
        return (EReference)resourceOperationEClass.getEStructuralFeatures().get(3);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResourceOperation_ReturnString() {
        return (EAttribute)resourceOperationEClass.getEStructuralFeatures().get(4);
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getInheritanceType() {
        return inheritanceTypeEEnum;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getDiscriminatorType() {
        return discriminatorTypeEEnum;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getHttpMethod() {
        return httpMethodEEnum;
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SculptormetamodelFactory getSculptormetamodelFactory() {
        return (SculptormetamodelFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        namedElementEClass = createEClass(NAMED_ELEMENT);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__DOC);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__HINT);

        applicationEClass = createEClass(APPLICATION);
        createEAttribute(applicationEClass, APPLICATION__BASE_PACKAGE);
        createEReference(applicationEClass, APPLICATION__MODULES);

        serviceEClass = createEClass(SERVICE);
        createEReference(serviceEClass, SERVICE__OPERATIONS);
        createEReference(serviceEClass, SERVICE__REPOSITORY_DEPENDENCIES);
        createEReference(serviceEClass, SERVICE__MODULE);
        createEAttribute(serviceEClass, SERVICE__OTHER_DEPENDENCIES);
        createEReference(serviceEClass, SERVICE__SERVICE_DEPENDENCIES);
        createEAttribute(serviceEClass, SERVICE__GAP_CLASS);
        createEAttribute(serviceEClass, SERVICE__WEB_SERVICE);
        createEAttribute(serviceEClass, SERVICE__REMOTE_INTERFACE);
        createEAttribute(serviceEClass, SERVICE__LOCAL_INTERFACE);
        createEReference(serviceEClass, SERVICE__SUBSCRIBE);

        repositoryEClass = createEClass(REPOSITORY);
        createEReference(repositoryEClass, REPOSITORY__OPERATIONS);
        createEReference(repositoryEClass, REPOSITORY__AGGREGATE_ROOT);
        createEReference(repositoryEClass, REPOSITORY__REPOSITORY_DEPENDENCIES);
        createEAttribute(repositoryEClass, REPOSITORY__OTHER_DEPENDENCIES);
        createEAttribute(repositoryEClass, REPOSITORY__GAP_CLASS);
        createEReference(repositoryEClass, REPOSITORY__SUBSCRIBE);

        domainObjectEClass = createEClass(DOMAIN_OBJECT);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__REFERENCES);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__EXTENDS);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__ATTRIBUTES);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__ABSTRACT);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__REPOSITORY);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__MODULE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__OPTIMISTIC_LOCKING);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__CACHE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__PACKAGE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__DATABASE_TABLE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__EXTENDS_NAME);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__VALIDATE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__GAP_CLASS);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__INHERITANCE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__DISCRIMINATOR_COLUMN_VALUE);
        createEAttribute(domainObjectEClass, DOMAIN_OBJECT__AGGREGATE_ROOT);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__BELONGS_TO_AGGREGATE);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__OPERATIONS);
        createEReference(domainObjectEClass, DOMAIN_OBJECT__TRAITS);

        referenceEClass = createEClass(REFERENCE);
        createEAttribute(referenceEClass, REFERENCE__MANY);
        createEAttribute(referenceEClass, REFERENCE__COLLECTION_TYPE);
        createEReference(referenceEClass, REFERENCE__OPPOSITE);
        createEReference(referenceEClass, REFERENCE__TO);
        createEAttribute(referenceEClass, REFERENCE__CASCADE);
        createEAttribute(referenceEClass, REFERENCE__ORDER_BY);
        createEAttribute(referenceEClass, REFERENCE__VISIBILITY);
        createEAttribute(referenceEClass, REFERENCE__CHANGEABLE);
        createEReference(referenceEClass, REFERENCE__FROM);
        createEAttribute(referenceEClass, REFERENCE__REQUIRED);
        createEAttribute(referenceEClass, REFERENCE__FETCH);
        createEAttribute(referenceEClass, REFERENCE__CACHE);
        createEAttribute(referenceEClass, REFERENCE__NATURAL_KEY);
        createEAttribute(referenceEClass, REFERENCE__INVERSE);
        createEAttribute(referenceEClass, REFERENCE__NULLABLE);
        createEAttribute(referenceEClass, REFERENCE__DATABASE_COLUMN);
        createEAttribute(referenceEClass, REFERENCE__VALIDATE);
        createEAttribute(referenceEClass, REFERENCE__TRANSIENT);
        createEAttribute(referenceEClass, REFERENCE__DATABASE_JOIN_TABLE);
        createEAttribute(referenceEClass, REFERENCE__DATABASE_JOIN_COLUMN);

        typedElementEClass = createEClass(TYPED_ELEMENT);
        createEAttribute(typedElementEClass, TYPED_ELEMENT__TYPE);
        createEAttribute(typedElementEClass, TYPED_ELEMENT__COLLECTION_TYPE);
        createEAttribute(typedElementEClass, TYPED_ELEMENT__MAP_KEY_TYPE);

        domainObjectTypedElementEClass = createEClass(DOMAIN_OBJECT_TYPED_ELEMENT);
        createEReference(domainObjectTypedElementEClass, DOMAIN_OBJECT_TYPED_ELEMENT__DOMAIN_OBJECT_TYPE);
        createEReference(domainObjectTypedElementEClass, DOMAIN_OBJECT_TYPED_ELEMENT__MAP_KEY_DOMAIN_OBJECT_TYPE);

        attributeEClass = createEClass(ATTRIBUTE);
        createEAttribute(attributeEClass, ATTRIBUTE__CHANGEABLE);
        createEAttribute(attributeEClass, ATTRIBUTE__DATABASE_TYPE);
        createEAttribute(attributeEClass, ATTRIBUTE__NULLABLE);
        createEAttribute(attributeEClass, ATTRIBUTE__NATURAL_KEY);
        createEAttribute(attributeEClass, ATTRIBUTE__VISIBILITY);
        createEAttribute(attributeEClass, ATTRIBUTE__REQUIRED);
        createEAttribute(attributeEClass, ATTRIBUTE__LENGTH);
        createEAttribute(attributeEClass, ATTRIBUTE__INDEX);
        createEAttribute(attributeEClass, ATTRIBUTE__DATABASE_COLUMN);
        createEAttribute(attributeEClass, ATTRIBUTE__VALIDATE);
        createEAttribute(attributeEClass, ATTRIBUTE__TRANSIENT);

        operationEClass = createEClass(OPERATION);
        createEAttribute(operationEClass, OPERATION__THROWS);
        createEAttribute(operationEClass, OPERATION__VISIBILITY);
        createEReference(operationEClass, OPERATION__PARAMETERS);
        createEReference(operationEClass, OPERATION__PUBLISH);

        parameterEClass = createEClass(PARAMETER);

        repositoryOperationEClass = createEClass(REPOSITORY_OPERATION);
        createEAttribute(repositoryOperationEClass, REPOSITORY_OPERATION__DELEGATE_TO_ACCESS_OBJECT);
        createEReference(repositoryOperationEClass, REPOSITORY_OPERATION__REPOSITORY);
        createEAttribute(repositoryOperationEClass, REPOSITORY_OPERATION__ACCESS_OBJECT_NAME);

        serviceOperationEClass = createEClass(SERVICE_OPERATION);
        createEReference(serviceOperationEClass, SERVICE_OPERATION__DELEGATE);
        createEReference(serviceOperationEClass, SERVICE_OPERATION__SERVICE);
        createEReference(serviceOperationEClass, SERVICE_OPERATION__SERVICE_DELEGATE);

        valueObjectEClass = createEClass(VALUE_OBJECT);
        createEAttribute(valueObjectEClass, VALUE_OBJECT__IMMUTABLE);
        createEAttribute(valueObjectEClass, VALUE_OBJECT__PERSISTENT);

        entityEClass = createEClass(ENTITY);
        createEAttribute(entityEClass, ENTITY__AUDITABLE);

        moduleEClass = createEClass(MODULE);
        createEAttribute(moduleEClass, MODULE__BASE_PACKAGE);
        createEReference(moduleEClass, MODULE__APPLICATION);
        createEReference(moduleEClass, MODULE__DOMAIN_OBJECTS);
        createEReference(moduleEClass, MODULE__CONSUMERS);
        createEReference(moduleEClass, MODULE__SERVICES);
        createEAttribute(moduleEClass, MODULE__EXTERNAL);
        createEAttribute(moduleEClass, MODULE__PERSISTENCE_UNIT);
        createEReference(moduleEClass, MODULE__RESOURCES);

        basicTypeEClass = createEClass(BASIC_TYPE);

        consumerEClass = createEClass(CONSUMER);
        createEReference(consumerEClass, CONSUMER__MODULE);
        createEReference(consumerEClass, CONSUMER__REPOSITORY_DEPENDENCIES);
        createEReference(consumerEClass, CONSUMER__SERVICE_DEPENDENCIES);
        createEAttribute(consumerEClass, CONSUMER__CHANNEL);
        createEReference(consumerEClass, CONSUMER__MESSAGE_ROOT);
        createEAttribute(consumerEClass, CONSUMER__OTHER_DEPENDENCIES);
        createEReference(consumerEClass, CONSUMER__SUBSCRIBE);

        enumEClass = createEClass(ENUM);
        createEReference(enumEClass, ENUM__VALUES);
        createEAttribute(enumEClass, ENUM__ORDINAL);

        enumValueEClass = createEClass(ENUM_VALUE);
        createEReference(enumValueEClass, ENUM_VALUE__PARAMETERS);

        enumConstructorParameterEClass = createEClass(ENUM_CONSTRUCTOR_PARAMETER);
        createEAttribute(enumConstructorParameterEClass, ENUM_CONSTRUCTOR_PARAMETER__VALUE);

        inheritanceEClass = createEClass(INHERITANCE);
        createEAttribute(inheritanceEClass, INHERITANCE__DISCRIMINATOR_COLUMN_NAME);
        createEAttribute(inheritanceEClass, INHERITANCE__DISCRIMINATOR_COLUMN_LENGTH);
        createEAttribute(inheritanceEClass, INHERITANCE__TYPE);
        createEAttribute(inheritanceEClass, INHERITANCE__DISCRIMINATOR_TYPE);

        dataTransferObjectEClass = createEClass(DATA_TRANSFER_OBJECT);

        commandEventEClass = createEClass(COMMAND_EVENT);

        domainEventEClass = createEClass(DOMAIN_EVENT);

        subscribeEClass = createEClass(SUBSCRIBE);
        createEAttribute(subscribeEClass, SUBSCRIBE__EVENT_BUS);
        createEAttribute(subscribeEClass, SUBSCRIBE__TOPIC);

        eventEClass = createEClass(EVENT);

        publishEClass = createEClass(PUBLISH);
        createEAttribute(publishEClass, PUBLISH__EVENT_BUS);
        createEAttribute(publishEClass, PUBLISH__TOPIC);
        createEReference(publishEClass, PUBLISH__EVENT_TYPE);

        traitEClass = createEClass(TRAIT);

        domainObjectOperationEClass = createEClass(DOMAIN_OBJECT_OPERATION);
        createEReference(domainObjectOperationEClass, DOMAIN_OBJECT_OPERATION__DOMAIN_OBJECT);
        createEAttribute(domainObjectOperationEClass, DOMAIN_OBJECT_OPERATION__ABSTRACT);

        resourceEClass = createEClass(RESOURCE);
        createEReference(resourceEClass, RESOURCE__SERVICE_DEPENDENCIES);
        createEAttribute(resourceEClass, RESOURCE__GAP_CLASS);
        createEAttribute(resourceEClass, RESOURCE__PATH);
        createEReference(resourceEClass, RESOURCE__OPERATIONS);
        createEReference(resourceEClass, RESOURCE__MODULE);

        resourceOperationEClass = createEClass(RESOURCE_OPERATION);
        createEReference(resourceOperationEClass, RESOURCE_OPERATION__RESOURCE);
        createEAttribute(resourceOperationEClass, RESOURCE_OPERATION__PATH);
        createEAttribute(resourceOperationEClass, RESOURCE_OPERATION__HTTP_METHOD);
        createEReference(resourceOperationEClass, RESOURCE_OPERATION__DELEGATE);
        createEAttribute(resourceOperationEClass, RESOURCE_OPERATION__RETURN_STRING);

        // Create enums
        inheritanceTypeEEnum = createEEnum(INHERITANCE_TYPE);
        discriminatorTypeEEnum = createEEnum(DISCRIMINATOR_TYPE);
        httpMethodEEnum = createEEnum(HTTP_METHOD);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Add supertypes to classes
        applicationEClass.getESuperTypes().add(this.getNamedElement());
        serviceEClass.getESuperTypes().add(this.getNamedElement());
        repositoryEClass.getESuperTypes().add(this.getNamedElement());
        domainObjectEClass.getESuperTypes().add(this.getNamedElement());
        referenceEClass.getESuperTypes().add(this.getNamedElement());
        typedElementEClass.getESuperTypes().add(this.getNamedElement());
        domainObjectTypedElementEClass.getESuperTypes().add(this.getTypedElement());
        attributeEClass.getESuperTypes().add(this.getTypedElement());
        operationEClass.getESuperTypes().add(this.getDomainObjectTypedElement());
        parameterEClass.getESuperTypes().add(this.getDomainObjectTypedElement());
        repositoryOperationEClass.getESuperTypes().add(this.getOperation());
        serviceOperationEClass.getESuperTypes().add(this.getOperation());
        valueObjectEClass.getESuperTypes().add(this.getDomainObject());
        entityEClass.getESuperTypes().add(this.getDomainObject());
        moduleEClass.getESuperTypes().add(this.getNamedElement());
        basicTypeEClass.getESuperTypes().add(this.getValueObject());
        consumerEClass.getESuperTypes().add(this.getNamedElement());
        enumEClass.getESuperTypes().add(this.getDomainObject());
        enumValueEClass.getESuperTypes().add(this.getNamedElement());
        dataTransferObjectEClass.getESuperTypes().add(this.getValueObject());
        commandEventEClass.getESuperTypes().add(this.getEvent());
        domainEventEClass.getESuperTypes().add(this.getEvent());
        eventEClass.getESuperTypes().add(this.getValueObject());
        traitEClass.getESuperTypes().add(this.getDomainObject());
        domainObjectOperationEClass.getESuperTypes().add(this.getOperation());
        resourceEClass.getESuperTypes().add(this.getNamedElement());
        resourceOperationEClass.getESuperTypes().add(this.getOperation());

        // Initialize classes and features; add operations and parameters
        initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNamedElement_Doc(), ecorePackage.getEString(), "doc", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNamedElement_Hint(), ecorePackage.getEString(), "hint", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getApplication_BasePackage(), ecorePackage.getEString(), "basePackage", null, 0, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getApplication_Modules(), this.getModule(), this.getModule_Application(), "modules", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getService_Operations(), this.getServiceOperation(), this.getServiceOperation_Service(), "operations", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getService_RepositoryDependencies(), this.getRepository(), null, "repositoryDependencies", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getService_Module(), this.getModule(), this.getModule_Services(), "module", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getService_OtherDependencies(), ecorePackage.getEString(), "otherDependencies", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getService_ServiceDependencies(), this.getService(), null, "serviceDependencies", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getService_GapClass(), ecorePackage.getEBoolean(), "gapClass", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getService_WebService(), ecorePackage.getEBoolean(), "webService", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getService_RemoteInterface(), ecorePackage.getEBoolean(), "remoteInterface", "true", 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getService_LocalInterface(), ecorePackage.getEBoolean(), "localInterface", "true", 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getService_Subscribe(), this.getSubscribe(), null, "subscribe", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(repositoryEClass, Repository.class, "Repository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRepository_Operations(), this.getRepositoryOperation(), this.getRepositoryOperation_Repository(), "operations", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRepository_AggregateRoot(), this.getDomainObject(), this.getDomainObject_Repository(), "aggregateRoot", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRepository_RepositoryDependencies(), this.getRepository(), null, "repositoryDependencies", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRepository_OtherDependencies(), ecorePackage.getEString(), "otherDependencies", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRepository_GapClass(), ecorePackage.getEBoolean(), "gapClass", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRepository_Subscribe(), this.getSubscribe(), null, "subscribe", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(domainObjectEClass, DomainObject.class, "DomainObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDomainObject_References(), this.getReference(), this.getReference_From(), "references", null, 0, -1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Extends(), this.getDomainObject(), null, "extends", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Repository(), this.getRepository(), this.getRepository_AggregateRoot(), "repository", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Module(), this.getModule(), this.getModule_DomainObjects(), "module", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_OptimisticLocking(), ecorePackage.getEBoolean(), "optimisticLocking", "true", 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_Cache(), ecorePackage.getEBoolean(), "cache", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_Package(), ecorePackage.getEString(), "package", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_DatabaseTable(), ecorePackage.getEString(), "databaseTable", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_ExtendsName(), ecorePackage.getEString(), "extendsName", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_Validate(), ecorePackage.getEString(), "validate", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_GapClass(), ecorePackage.getEBoolean(), "gapClass", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Inheritance(), this.getInheritance(), null, "inheritance", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_DiscriminatorColumnValue(), ecorePackage.getEString(), "discriminatorColumnValue", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObject_AggregateRoot(), ecorePackage.getEBoolean(), "aggregateRoot", "true", 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_BelongsToAggregate(), this.getDomainObject(), null, "belongsToAggregate", null, 0, 1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Operations(), this.getDomainObjectOperation(), this.getDomainObjectOperation_DomainObject(), "operations", null, 0, -1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObject_Traits(), this.getTrait(), null, "traits", null, 0, -1, DomainObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getReference_Many(), ecorePackage.getEBoolean(), "many", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_CollectionType(), ecorePackage.getEString(), "collectionType", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReference_Opposite(), this.getReference(), null, "opposite", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReference_To(), this.getDomainObject(), null, "to", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Cascade(), ecorePackage.getEString(), "cascade", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_OrderBy(), ecorePackage.getEString(), "orderBy", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Changeable(), ecorePackage.getEBoolean(), "changeable", "true", 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getReference_From(), this.getDomainObject(), this.getDomainObject_References(), "from", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Fetch(), ecorePackage.getEString(), "fetch", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Cache(), ecorePackage.getEBoolean(), "cache", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_NaturalKey(), ecorePackage.getEBoolean(), "naturalKey", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Inverse(), ecorePackage.getEBoolean(), "inverse", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Nullable(), ecorePackage.getEBoolean(), "nullable", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_DatabaseColumn(), ecorePackage.getEString(), "databaseColumn", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Validate(), ecorePackage.getEString(), "validate", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_Transient(), ecorePackage.getEBoolean(), "transient", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_DatabaseJoinTable(), ecorePackage.getEString(), "databaseJoinTable", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_DatabaseJoinColumn(), ecorePackage.getEString(), "databaseJoinColumn", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(typedElementEClass, TypedElement.class, "TypedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTypedElement_Type(), ecorePackage.getEString(), "type", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTypedElement_CollectionType(), ecorePackage.getEString(), "collectionType", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTypedElement_MapKeyType(), ecorePackage.getEString(), "mapKeyType", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(domainObjectTypedElementEClass, DomainObjectTypedElement.class, "DomainObjectTypedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDomainObjectTypedElement_DomainObjectType(), this.getDomainObject(), null, "domainObjectType", null, 0, 1, DomainObjectTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDomainObjectTypedElement_MapKeyDomainObjectType(), this.getDomainObject(), null, "mapKeyDomainObjectType", null, 0, 1, DomainObjectTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttribute_Changeable(), ecorePackage.getEBoolean(), "changeable", "true", 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_DatabaseType(), ecorePackage.getEString(), "databaseType", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Nullable(), ecorePackage.getEBoolean(), "nullable", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_NaturalKey(), ecorePackage.getEBoolean(), "naturalKey", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Required(), ecorePackage.getEBoolean(), "required", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Length(), ecorePackage.getEString(), "length", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Index(), ecorePackage.getEBoolean(), "index", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_DatabaseColumn(), ecorePackage.getEString(), "databaseColumn", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Validate(), ecorePackage.getEString(), "validate", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttribute_Transient(), ecorePackage.getEBoolean(), "transient", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperation_Throws(), ecorePackage.getEString(), "throws", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperation_Visibility(), ecorePackage.getEString(), "visibility", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperation_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperation_Publish(), this.getPublish(), null, "publish", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(repositoryOperationEClass, RepositoryOperation.class, "RepositoryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRepositoryOperation_DelegateToAccessObject(), ecorePackage.getEBoolean(), "delegateToAccessObject", "false", 0, 1, RepositoryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRepositoryOperation_Repository(), this.getRepository(), this.getRepository_Operations(), "repository", null, 1, 1, RepositoryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRepositoryOperation_AccessObjectName(), ecorePackage.getEString(), "accessObjectName", null, 0, 1, RepositoryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(serviceOperationEClass, ServiceOperation.class, "ServiceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getServiceOperation_Delegate(), this.getRepositoryOperation(), null, "delegate", null, 0, 1, ServiceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceOperation_Service(), this.getService(), this.getService_Operations(), "service", null, 1, 1, ServiceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getServiceOperation_ServiceDelegate(), this.getServiceOperation(), null, "serviceDelegate", null, 0, 1, ServiceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(valueObjectEClass, ValueObject.class, "ValueObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValueObject_Immutable(), ecorePackage.getEBoolean(), "immutable", "true", 0, 1, ValueObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValueObject_Persistent(), ecorePackage.getEBoolean(), "persistent", "true", 0, 1, ValueObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEntity_Auditable(), ecorePackage.getEBoolean(), "auditable", "true", 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getModule_BasePackage(), ecorePackage.getEString(), "basePackage", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModule_Application(), this.getApplication(), this.getApplication_Modules(), "application", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModule_DomainObjects(), this.getDomainObject(), this.getDomainObject_Module(), "domainObjects", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModule_Consumers(), this.getConsumer(), this.getConsumer_Module(), "consumers", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModule_Services(), this.getService(), this.getService_Module(), "services", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_External(), ecorePackage.getEBoolean(), "external", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_PersistenceUnit(), ecorePackage.getEString(), "persistenceUnit", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModule_Resources(), this.getResource(), this.getResource_Module(), "resources", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(basicTypeEClass, BasicType.class, "BasicType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(consumerEClass, Consumer.class, "Consumer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConsumer_Module(), this.getModule(), this.getModule_Consumers(), "module", null, 0, 1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConsumer_RepositoryDependencies(), this.getRepository(), null, "repositoryDependencies", null, 0, -1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConsumer_ServiceDependencies(), this.getService(), null, "serviceDependencies", null, 0, -1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConsumer_Channel(), ecorePackage.getEString(), "channel", null, 0, 1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConsumer_MessageRoot(), this.getDomainObject(), null, "messageRoot", null, 0, 1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConsumer_OtherDependencies(), ecorePackage.getEString(), "otherDependencies", null, 0, -1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConsumer_Subscribe(), this.getSubscribe(), null, "subscribe", null, 0, 1, Consumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumEClass, sculptormetamodel.Enum.class, "Enum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEnum_Values(), this.getEnumValue(), null, "values", null, 0, -1, sculptormetamodel.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEnum_Ordinal(), ecorePackage.getEBoolean(), "ordinal", null, 0, 1, sculptormetamodel.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumValueEClass, EnumValue.class, "EnumValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEnumValue_Parameters(), this.getEnumConstructorParameter(), null, "parameters", null, 0, -1, EnumValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumConstructorParameterEClass, EnumConstructorParameter.class, "EnumConstructorParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEnumConstructorParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, EnumConstructorParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(inheritanceEClass, Inheritance.class, "Inheritance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInheritance_DiscriminatorColumnName(), ecorePackage.getEString(), "discriminatorColumnName", null, 0, 1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInheritance_DiscriminatorColumnLength(), ecorePackage.getEString(), "discriminatorColumnLength", null, 0, 1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInheritance_Type(), this.getInheritanceType(), "type", null, 0, 1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInheritance_DiscriminatorType(), this.getDiscriminatorType(), "discriminatorType", null, 0, 1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataTransferObjectEClass, DataTransferObject.class, "DataTransferObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(commandEventEClass, CommandEvent.class, "CommandEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(domainEventEClass, DomainEvent.class, "DomainEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(subscribeEClass, Subscribe.class, "Subscribe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSubscribe_EventBus(), ecorePackage.getEString(), "eventBus", null, 0, 1, Subscribe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSubscribe_Topic(), ecorePackage.getEString(), "topic", null, 0, 1, Subscribe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(publishEClass, Publish.class, "Publish", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPublish_EventBus(), ecorePackage.getEString(), "eventBus", null, 0, 1, Publish.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPublish_Topic(), ecorePackage.getEString(), "topic", null, 0, 1, Publish.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPublish_EventType(), this.getEvent(), null, "eventType", null, 0, 1, Publish.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(traitEClass, Trait.class, "Trait", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(domainObjectOperationEClass, DomainObjectOperation.class, "DomainObjectOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDomainObjectOperation_DomainObject(), this.getDomainObject(), this.getDomainObject_Operations(), "domainObject", null, 0, 1, DomainObjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDomainObjectOperation_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, DomainObjectOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResource_ServiceDependencies(), this.getService(), null, "serviceDependencies", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResource_GapClass(), ecorePackage.getEBoolean(), "gapClass", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResource_Path(), ecorePackage.getEString(), "path", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResource_Operations(), this.getResourceOperation(), this.getResourceOperation_Resource(), "operations", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResource_Module(), this.getModule(), this.getModule_Resources(), "module", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceOperationEClass, ResourceOperation.class, "ResourceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourceOperation_Resource(), this.getResource(), this.getResource_Operations(), "resource", null, 0, 1, ResourceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResourceOperation_Path(), ecorePackage.getEString(), "path", null, 0, 1, ResourceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResourceOperation_HttpMethod(), this.getHttpMethod(), "httpMethod", "", 0, 1, ResourceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceOperation_Delegate(), this.getServiceOperation(), null, "delegate", null, 0, 1, ResourceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResourceOperation_ReturnString(), ecorePackage.getEString(), "returnString", null, 0, 1, ResourceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(inheritanceTypeEEnum, InheritanceType.class, "InheritanceType");
        addEEnumLiteral(inheritanceTypeEEnum, InheritanceType.SINGLE_TABLE_LITERAL);
        addEEnumLiteral(inheritanceTypeEEnum, InheritanceType.JOINED_LITERAL);

        initEEnum(discriminatorTypeEEnum, DiscriminatorType.class, "DiscriminatorType");
        addEEnumLiteral(discriminatorTypeEEnum, DiscriminatorType.STRING_LITERAL);
        addEEnumLiteral(discriminatorTypeEEnum, DiscriminatorType.CHAR_LITERAL);
        addEEnumLiteral(discriminatorTypeEEnum, DiscriminatorType.INTEGER_LITERAL);

        initEEnum(httpMethodEEnum, HttpMethod.class, "HttpMethod");
        addEEnumLiteral(httpMethodEEnum, HttpMethod.UNDEFINED_LITERAL);
        addEEnumLiteral(httpMethodEEnum, HttpMethod.GET_LITERAL);
        addEEnumLiteral(httpMethodEEnum, HttpMethod.POST_LITERAL);
        addEEnumLiteral(httpMethodEEnum, HttpMethod.PUT_LITERAL);
        addEEnumLiteral(httpMethodEEnum, HttpMethod.DELETE_LITERAL);

        // Create resource
        createResource(eNS_URI);
    }

} //SculptormetamodelPackageImpl
