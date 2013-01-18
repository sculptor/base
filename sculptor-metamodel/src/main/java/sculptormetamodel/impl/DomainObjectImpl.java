/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptormetamodel.Attribute;
import sculptormetamodel.DomainObject;
import sculptormetamodel.DomainObjectOperation;
import sculptormetamodel.Inheritance;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.Repository;
import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.Trait;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getReferences <em>References</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getModule <em>Module</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#isOptimisticLocking <em>Optimistic Locking</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#isCache <em>Cache</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getDatabaseTable <em>Database Table</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getExtendsName <em>Extends Name</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getValidate <em>Validate</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#isGapClass <em>Gap Class</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getInheritance <em>Inheritance</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getDiscriminatorColumnValue <em>Discriminator Column Value</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#isAggregateRoot <em>Aggregate Root</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getBelongsToAggregate <em>Belongs To Aggregate</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link sculptormetamodel.impl.DomainObjectImpl#getTraits <em>Traits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DomainObjectImpl extends NamedElementImpl implements DomainObject {
    /**
     * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getReferences()
     * @generated
     * @ordered
     */
	protected EList references;

    /**
     * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExtends()
     * @generated
     * @ordered
     */
	protected DomainObject extends_;

    /**
     * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAttributes()
     * @generated
     * @ordered
     */
	protected EList attributes;

    /**
     * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected static final boolean ABSTRACT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

    /**
     * The cached value of the '{@link #getRepository() <em>Repository</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRepository()
     * @generated
     * @ordered
     */
	protected Repository repository;

    /**
     * The default value of the '{@link #isOptimisticLocking() <em>Optimistic Locking</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOptimisticLocking()
     * @generated
     * @ordered
     */
	protected static final boolean OPTIMISTIC_LOCKING_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isOptimisticLocking() <em>Optimistic Locking</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOptimisticLocking()
     * @generated
     * @ordered
     */
	protected boolean optimisticLocking = OPTIMISTIC_LOCKING_EDEFAULT;

    /**
     * The default value of the '{@link #isCache() <em>Cache</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCache()
     * @generated
     * @ordered
     */
    protected static final boolean CACHE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isCache() <em>Cache</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCache()
     * @generated
     * @ordered
     */
    protected boolean cache = CACHE_EDEFAULT;

    /**
     * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackage()
     * @generated
     * @ordered
     */
    protected String package_ = PACKAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getDatabaseTable() <em>Database Table</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseTable()
     * @generated
     * @ordered
     */
    protected static final String DATABASE_TABLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDatabaseTable() <em>Database Table</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseTable()
     * @generated
     * @ordered
     */
    protected String databaseTable = DATABASE_TABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getExtendsName() <em>Extends Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtendsName()
     * @generated
     * @ordered
     */
    protected static final String EXTENDS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExtendsName() <em>Extends Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtendsName()
     * @generated
     * @ordered
     */
    protected String extendsName = EXTENDS_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getValidate() <em>Validate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValidate()
     * @generated
     * @ordered
     */
	protected static final String VALIDATE_EDEFAULT = null;

				/**
     * The cached value of the '{@link #getValidate() <em>Validate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValidate()
     * @generated
     * @ordered
     */
	protected String validate = VALIDATE_EDEFAULT;

				/**
     * The default value of the '{@link #isGapClass() <em>Gap Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGapClass()
     * @generated
     * @ordered
     */
    protected static final boolean GAP_CLASS_EDEFAULT = false;

                /**
     * The cached value of the '{@link #isGapClass() <em>Gap Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGapClass()
     * @generated
     * @ordered
     */
    protected boolean gapClass = GAP_CLASS_EDEFAULT;

                /**
     * The cached value of the '{@link #getInheritance() <em>Inheritance</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInheritance()
     * @generated
     * @ordered
     */
    protected Inheritance inheritance;

                /**
     * The default value of the '{@link #getDiscriminatorColumnValue() <em>Discriminator Column Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiscriminatorColumnValue()
     * @generated
     * @ordered
     */
    protected static final String DISCRIMINATOR_COLUMN_VALUE_EDEFAULT = null;

                /**
     * The cached value of the '{@link #getDiscriminatorColumnValue() <em>Discriminator Column Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiscriminatorColumnValue()
     * @generated
     * @ordered
     */
    protected String discriminatorColumnValue = DISCRIMINATOR_COLUMN_VALUE_EDEFAULT;

                /**
     * The default value of the '{@link #isAggregateRoot() <em>Aggregate Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAggregateRoot()
     * @generated
     * @ordered
     */
    protected static final boolean AGGREGATE_ROOT_EDEFAULT = true;

                                                                /**
     * The cached value of the '{@link #isAggregateRoot() <em>Aggregate Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAggregateRoot()
     * @generated
     * @ordered
     */
    protected boolean aggregateRoot = AGGREGATE_ROOT_EDEFAULT;

                                                                /**
     * The cached value of the '{@link #getBelongsToAggregate() <em>Belongs To Aggregate</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBelongsToAggregate()
     * @generated
     * @ordered
     */
    protected DomainObject belongsToAggregate;

                                                                /**
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
    protected EList operations;

                                                                /**
     * The cached value of the '{@link #getTraits() <em>Traits</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTraits()
     * @generated
     * @ordered
     */
    protected EList traits;

                                                                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DomainObjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.DOMAIN_OBJECT;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getReferences() {
        if (references == null) {
            references = new EObjectContainmentWithInverseEList(Reference.class, this, SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES, SculptormetamodelPackage.REFERENCE__FROM);
        }
        return references;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject getExtends() {
        if (extends_ != null && extends_.eIsProxy()) {
            InternalEObject oldExtends = (InternalEObject)extends_;
            extends_ = (DomainObject)eResolveProxy(oldExtends);
            if (extends_ != oldExtends) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS, oldExtends, extends_));
            }
        }
        return extends_;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject basicGetExtends() {
        return extends_;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExtends(DomainObject newExtends) {
        DomainObject oldExtends = extends_;
        extends_ = newExtends;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS, oldExtends, extends_));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getAttributes() {
        if (attributes == null) {
            attributes = new EObjectContainmentEList(Attribute.class, this, SculptormetamodelPackage.DOMAIN_OBJECT__ATTRIBUTES);
        }
        return attributes;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAbstract() {
        return abstract_;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbstract(boolean newAbstract) {
        boolean oldAbstract = abstract_;
        abstract_ = newAbstract;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__ABSTRACT, oldAbstract, abstract_));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Repository getRepository() {
        return repository;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs) {
        Repository oldRepository = repository;
        repository = newRepository;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY, oldRepository, newRepository);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRepository(Repository newRepository) {
        if (newRepository != repository) {
            NotificationChain msgs = null;
            if (repository != null)
                msgs = ((InternalEObject)repository).eInverseRemove(this, SculptormetamodelPackage.REPOSITORY__AGGREGATE_ROOT, Repository.class, msgs);
            if (newRepository != null)
                msgs = ((InternalEObject)newRepository).eInverseAdd(this, SculptormetamodelPackage.REPOSITORY__AGGREGATE_ROOT, Repository.class, msgs);
            msgs = basicSetRepository(newRepository, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY, newRepository, newRepository));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Module getModule() {
        if (eContainerFeatureID() != SculptormetamodelPackage.DOMAIN_OBJECT__MODULE) return null;
        return (Module)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newModule, SculptormetamodelPackage.DOMAIN_OBJECT__MODULE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModule(Module newModule) {
        if (newModule != eInternalContainer() || (eContainerFeatureID() != SculptormetamodelPackage.DOMAIN_OBJECT__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newModule != null)
                msgs = ((InternalEObject)newModule).eInverseAdd(this, SculptormetamodelPackage.MODULE__DOMAIN_OBJECTS, Module.class, msgs);
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__MODULE, newModule, newModule));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isOptimisticLocking() {
        return optimisticLocking;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOptimisticLocking(boolean newOptimisticLocking) {
        boolean oldOptimisticLocking = optimisticLocking;
        optimisticLocking = newOptimisticLocking;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__OPTIMISTIC_LOCKING, oldOptimisticLocking, optimisticLocking));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isCache() {
        return cache;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCache(boolean newCache) {
        boolean oldCache = cache;
        cache = newCache;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__CACHE, oldCache, cache));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPackage() {
        return package_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPackage(String newPackage) {
        String oldPackage = package_;
        package_ = newPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__PACKAGE, oldPackage, package_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDatabaseTable() {
        return databaseTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatabaseTable(String newDatabaseTable) {
        String oldDatabaseTable = databaseTable;
        databaseTable = newDatabaseTable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__DATABASE_TABLE, oldDatabaseTable, databaseTable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExtendsName() {
        return extendsName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExtendsName(String newExtendsName) {
        String oldExtendsName = extendsName;
        extendsName = newExtendsName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS_NAME, oldExtendsName, extendsName));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getValidate() {
        return validate;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValidate(String newValidate) {
        String oldValidate = validate;
        validate = newValidate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__VALIDATE, oldValidate, validate));
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isGapClass() {
        return gapClass;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGapClass(boolean newGapClass) {
        boolean oldGapClass = gapClass;
        gapClass = newGapClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__GAP_CLASS, oldGapClass, gapClass));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Inheritance getInheritance() {
        if (inheritance != null && inheritance.eIsProxy()) {
            InternalEObject oldInheritance = (InternalEObject)inheritance;
            inheritance = (Inheritance)eResolveProxy(oldInheritance);
            if (inheritance != oldInheritance) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.DOMAIN_OBJECT__INHERITANCE, oldInheritance, inheritance));
            }
        }
        return inheritance;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Inheritance basicGetInheritance() {
        return inheritance;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInheritance(Inheritance newInheritance) {
        Inheritance oldInheritance = inheritance;
        inheritance = newInheritance;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__INHERITANCE, oldInheritance, inheritance));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDiscriminatorColumnValue() {
        return discriminatorColumnValue;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDiscriminatorColumnValue(String newDiscriminatorColumnValue) {
        String oldDiscriminatorColumnValue = discriminatorColumnValue;
        discriminatorColumnValue = newDiscriminatorColumnValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__DISCRIMINATOR_COLUMN_VALUE, oldDiscriminatorColumnValue, discriminatorColumnValue));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAggregateRoot() {
        return aggregateRoot;
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAggregateRoot(boolean newAggregateRoot) {
        boolean oldAggregateRoot = aggregateRoot;
        aggregateRoot = newAggregateRoot;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__AGGREGATE_ROOT, oldAggregateRoot, aggregateRoot));
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject getBelongsToAggregate() {
        if (belongsToAggregate != null && belongsToAggregate.eIsProxy()) {
            InternalEObject oldBelongsToAggregate = (InternalEObject)belongsToAggregate;
            belongsToAggregate = (DomainObject)eResolveProxy(oldBelongsToAggregate);
            if (belongsToAggregate != oldBelongsToAggregate) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.DOMAIN_OBJECT__BELONGS_TO_AGGREGATE, oldBelongsToAggregate, belongsToAggregate));
            }
        }
        return belongsToAggregate;
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject basicGetBelongsToAggregate() {
        return belongsToAggregate;
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBelongsToAggregate(DomainObject newBelongsToAggregate) {
        DomainObject oldBelongsToAggregate = belongsToAggregate;
        belongsToAggregate = newBelongsToAggregate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.DOMAIN_OBJECT__BELONGS_TO_AGGREGATE, oldBelongsToAggregate, belongsToAggregate));
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentWithInverseEList(DomainObjectOperation.class, this, SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS, SculptormetamodelPackage.DOMAIN_OBJECT_OPERATION__DOMAIN_OBJECT);
        }
        return operations;
    }

                                                                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getTraits() {
        if (traits == null) {
            traits = new EObjectResolvingEList(Trait.class, this, SculptormetamodelPackage.DOMAIN_OBJECT__TRAITS);
        }
        return traits;
    }

                                                                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES:
                return ((InternalEList)getReferences()).basicAdd(otherEnd, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY:
                if (repository != null)
                    msgs = ((InternalEObject)repository).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY, null, msgs);
                return basicSetRepository((Repository)otherEnd, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetModule((Module)otherEnd, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS:
                return ((InternalEList)getOperations()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES:
                return ((InternalEList)getReferences()).basicRemove(otherEnd, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__ATTRIBUTES:
                return ((InternalEList)getAttributes()).basicRemove(otherEnd, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY:
                return basicSetRepository(null, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                return basicSetModule(null, msgs);
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS:
                return ((InternalEList)getOperations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                return eInternalContainer().eInverseRemove(this, SculptormetamodelPackage.MODULE__DOMAIN_OBJECTS, Module.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES:
                return getReferences();
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS:
                if (resolve) return getExtends();
                return basicGetExtends();
            case SculptormetamodelPackage.DOMAIN_OBJECT__ATTRIBUTES:
                return getAttributes();
            case SculptormetamodelPackage.DOMAIN_OBJECT__ABSTRACT:
                return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY:
                return getRepository();
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                return getModule();
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPTIMISTIC_LOCKING:
                return isOptimisticLocking() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.DOMAIN_OBJECT__CACHE:
                return isCache() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.DOMAIN_OBJECT__PACKAGE:
                return getPackage();
            case SculptormetamodelPackage.DOMAIN_OBJECT__DATABASE_TABLE:
                return getDatabaseTable();
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS_NAME:
                return getExtendsName();
            case SculptormetamodelPackage.DOMAIN_OBJECT__VALIDATE:
                return getValidate();
            case SculptormetamodelPackage.DOMAIN_OBJECT__GAP_CLASS:
                return isGapClass() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.DOMAIN_OBJECT__INHERITANCE:
                if (resolve) return getInheritance();
                return basicGetInheritance();
            case SculptormetamodelPackage.DOMAIN_OBJECT__DISCRIMINATOR_COLUMN_VALUE:
                return getDiscriminatorColumnValue();
            case SculptormetamodelPackage.DOMAIN_OBJECT__AGGREGATE_ROOT:
                return isAggregateRoot() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.DOMAIN_OBJECT__BELONGS_TO_AGGREGATE:
                if (resolve) return getBelongsToAggregate();
                return basicGetBelongsToAggregate();
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS:
                return getOperations();
            case SculptormetamodelPackage.DOMAIN_OBJECT__TRAITS:
                return getTraits();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES:
                getReferences().clear();
                getReferences().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS:
                setExtends((DomainObject)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__ATTRIBUTES:
                getAttributes().clear();
                getAttributes().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__ABSTRACT:
                setAbstract(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY:
                setRepository((Repository)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                setModule((Module)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPTIMISTIC_LOCKING:
                setOptimisticLocking(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__CACHE:
                setCache(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__PACKAGE:
                setPackage((String)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__DATABASE_TABLE:
                setDatabaseTable((String)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS_NAME:
                setExtendsName((String)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__VALIDATE:
                setValidate((String)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__GAP_CLASS:
                setGapClass(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__INHERITANCE:
                setInheritance((Inheritance)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__DISCRIMINATOR_COLUMN_VALUE:
                setDiscriminatorColumnValue((String)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__AGGREGATE_ROOT:
                setAggregateRoot(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__BELONGS_TO_AGGREGATE:
                setBelongsToAggregate((DomainObject)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__TRAITS:
                getTraits().clear();
                getTraits().addAll((Collection)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES:
                getReferences().clear();
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS:
                setExtends((DomainObject)null);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__ATTRIBUTES:
                getAttributes().clear();
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__ABSTRACT:
                setAbstract(ABSTRACT_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY:
                setRepository((Repository)null);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                setModule((Module)null);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPTIMISTIC_LOCKING:
                setOptimisticLocking(OPTIMISTIC_LOCKING_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__CACHE:
                setCache(CACHE_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__PACKAGE:
                setPackage(PACKAGE_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__DATABASE_TABLE:
                setDatabaseTable(DATABASE_TABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS_NAME:
                setExtendsName(EXTENDS_NAME_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__VALIDATE:
                setValidate(VALIDATE_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__GAP_CLASS:
                setGapClass(GAP_CLASS_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__INHERITANCE:
                setInheritance((Inheritance)null);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__DISCRIMINATOR_COLUMN_VALUE:
                setDiscriminatorColumnValue(DISCRIMINATOR_COLUMN_VALUE_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__AGGREGATE_ROOT:
                setAggregateRoot(AGGREGATE_ROOT_EDEFAULT);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__BELONGS_TO_AGGREGATE:
                setBelongsToAggregate((DomainObject)null);
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS:
                getOperations().clear();
                return;
            case SculptormetamodelPackage.DOMAIN_OBJECT__TRAITS:
                getTraits().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES:
                return references != null && !references.isEmpty();
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS:
                return extends_ != null;
            case SculptormetamodelPackage.DOMAIN_OBJECT__ATTRIBUTES:
                return attributes != null && !attributes.isEmpty();
            case SculptormetamodelPackage.DOMAIN_OBJECT__ABSTRACT:
                return abstract_ != ABSTRACT_EDEFAULT;
            case SculptormetamodelPackage.DOMAIN_OBJECT__REPOSITORY:
                return repository != null;
            case SculptormetamodelPackage.DOMAIN_OBJECT__MODULE:
                return getModule() != null;
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPTIMISTIC_LOCKING:
                return optimisticLocking != OPTIMISTIC_LOCKING_EDEFAULT;
            case SculptormetamodelPackage.DOMAIN_OBJECT__CACHE:
                return cache != CACHE_EDEFAULT;
            case SculptormetamodelPackage.DOMAIN_OBJECT__PACKAGE:
                return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
            case SculptormetamodelPackage.DOMAIN_OBJECT__DATABASE_TABLE:
                return DATABASE_TABLE_EDEFAULT == null ? databaseTable != null : !DATABASE_TABLE_EDEFAULT.equals(databaseTable);
            case SculptormetamodelPackage.DOMAIN_OBJECT__EXTENDS_NAME:
                return EXTENDS_NAME_EDEFAULT == null ? extendsName != null : !EXTENDS_NAME_EDEFAULT.equals(extendsName);
            case SculptormetamodelPackage.DOMAIN_OBJECT__VALIDATE:
                return VALIDATE_EDEFAULT == null ? validate != null : !VALIDATE_EDEFAULT.equals(validate);
            case SculptormetamodelPackage.DOMAIN_OBJECT__GAP_CLASS:
                return gapClass != GAP_CLASS_EDEFAULT;
            case SculptormetamodelPackage.DOMAIN_OBJECT__INHERITANCE:
                return inheritance != null;
            case SculptormetamodelPackage.DOMAIN_OBJECT__DISCRIMINATOR_COLUMN_VALUE:
                return DISCRIMINATOR_COLUMN_VALUE_EDEFAULT == null ? discriminatorColumnValue != null : !DISCRIMINATOR_COLUMN_VALUE_EDEFAULT.equals(discriminatorColumnValue);
            case SculptormetamodelPackage.DOMAIN_OBJECT__AGGREGATE_ROOT:
                return aggregateRoot != AGGREGATE_ROOT_EDEFAULT;
            case SculptormetamodelPackage.DOMAIN_OBJECT__BELONGS_TO_AGGREGATE:
                return belongsToAggregate != null;
            case SculptormetamodelPackage.DOMAIN_OBJECT__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case SculptormetamodelPackage.DOMAIN_OBJECT__TRAITS:
                return traits != null && !traits.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (abstract: ");
        result.append(abstract_);
        result.append(", optimisticLocking: ");
        result.append(optimisticLocking);
        result.append(", cache: ");
        result.append(cache);
        result.append(", package: ");
        result.append(package_);
        result.append(", databaseTable: ");
        result.append(databaseTable);
        result.append(", extendsName: ");
        result.append(extendsName);
        result.append(", validate: ");
        result.append(validate);
        result.append(", gapClass: ");
        result.append(gapClass);
        result.append(", discriminatorColumnValue: ");
        result.append(discriminatorColumnValue);
        result.append(", aggregateRoot: ");
        result.append(aggregateRoot);
        result.append(')');
        return result.toString();
    }

} //DomainObjectImpl