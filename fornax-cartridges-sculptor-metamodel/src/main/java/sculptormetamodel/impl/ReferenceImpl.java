/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import sculptormetamodel.DomainObject;
import sculptormetamodel.Reference;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isMany <em>Many</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getTo <em>To</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getCascade <em>Cascade</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getOrderBy <em>Order By</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getFrom <em>From</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getFetch <em>Fetch</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isCache <em>Cache</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isNaturalKey <em>Natural Key</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isInverse <em>Inverse</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getDatabaseColumn <em>Database Column</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getValidate <em>Validate</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getDatabaseJoinTable <em>Database Join Table</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ReferenceImpl#getDatabaseJoinColumn <em>Database Join Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends NamedElementImpl implements Reference {
    /**
     * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMany()
     * @generated
     * @ordered
     */
	protected static final boolean MANY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMany()
     * @generated
     * @ordered
     */
	protected boolean many = MANY_EDEFAULT;

    /**
     * The default value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionType()
     * @generated
     * @ordered
     */
	protected static final String COLLECTION_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionType()
     * @generated
     * @ordered
     */
	protected String collectionType = COLLECTION_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOpposite()
     * @generated
     * @ordered
     */
	protected Reference opposite;

    /**
     * The cached value of the '{@link #getTo() <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
	protected DomainObject to;

    /**
     * The default value of the '{@link #getCascade() <em>Cascade</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCascade()
     * @generated
     * @ordered
     */
	protected static final String CASCADE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCascade() <em>Cascade</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCascade()
     * @generated
     * @ordered
     */
	protected String cascade = CASCADE_EDEFAULT;

    /**
     * The default value of the '{@link #getOrderBy() <em>Order By</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOrderBy()
     * @generated
     * @ordered
     */
	protected static final String ORDER_BY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOrderBy() <em>Order By</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOrderBy()
     * @generated
     * @ordered
     */
	protected String orderBy = ORDER_BY_EDEFAULT;

    /**
     * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
	protected static final String VISIBILITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
	protected String visibility = VISIBILITY_EDEFAULT;

    /**
     * The default value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isChangeable()
     * @generated
     * @ordered
     */
	protected static final boolean CHANGEABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isChangeable()
     * @generated
     * @ordered
     */
	protected boolean changeable = CHANGEABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isRequired()
     * @generated
     * @ordered
     */
	protected static final boolean REQUIRED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isRequired()
     * @generated
     * @ordered
     */
	protected boolean required = REQUIRED_EDEFAULT;

    /**
     * The default value of the '{@link #getFetch() <em>Fetch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFetch()
     * @generated
     * @ordered
     */
    protected static final String FETCH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFetch() <em>Fetch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFetch()
     * @generated
     * @ordered
     */
    protected String fetch = FETCH_EDEFAULT;

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
     * The default value of the '{@link #isNaturalKey() <em>Natural Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNaturalKey()
     * @generated
     * @ordered
     */
    protected static final boolean NATURAL_KEY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNaturalKey() <em>Natural Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNaturalKey()
     * @generated
     * @ordered
     */
    protected boolean naturalKey = NATURAL_KEY_EDEFAULT;

    /**
     * The default value of the '{@link #isInverse() <em>Inverse</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInverse()
     * @generated
     * @ordered
     */
    protected static final boolean INVERSE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isInverse() <em>Inverse</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInverse()
     * @generated
     * @ordered
     */
    protected boolean inverse = INVERSE_EDEFAULT;

    /**
     * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNullable()
     * @generated
     * @ordered
     */
    protected static final boolean NULLABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNullable()
     * @generated
     * @ordered
     */
    protected boolean nullable = NULLABLE_EDEFAULT;

    /**
     * The default value of the '{@link #getDatabaseColumn() <em>Database Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseColumn()
     * @generated
     * @ordered
     */
    protected static final String DATABASE_COLUMN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDatabaseColumn() <em>Database Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseColumn()
     * @generated
     * @ordered
     */
    protected String databaseColumn = DATABASE_COLUMN_EDEFAULT;

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
     * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTransient()
     * @generated
     * @ordered
     */
    protected static final boolean TRANSIENT_EDEFAULT = false;

                /**
     * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTransient()
     * @generated
     * @ordered
     */
    protected boolean transient_ = TRANSIENT_EDEFAULT;

                /**
     * The default value of the '{@link #getDatabaseJoinTable() <em>Database Join Table</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseJoinTable()
     * @generated
     * @ordered
     */
    protected static final String DATABASE_JOIN_TABLE_EDEFAULT = null;

                /**
     * The cached value of the '{@link #getDatabaseJoinTable() <em>Database Join Table</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseJoinTable()
     * @generated
     * @ordered
     */
    protected String databaseJoinTable = DATABASE_JOIN_TABLE_EDEFAULT;

                /**
     * The default value of the '{@link #getDatabaseJoinColumn() <em>Database Join Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseJoinColumn()
     * @generated
     * @ordered
     */
    protected static final String DATABASE_JOIN_COLUMN_EDEFAULT = null;

                /**
     * The cached value of the '{@link #getDatabaseJoinColumn() <em>Database Join Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabaseJoinColumn()
     * @generated
     * @ordered
     */
    protected String databaseJoinColumn = DATABASE_JOIN_COLUMN_EDEFAULT;

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isMany() {
        return many;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMany(boolean newMany) {
        boolean oldMany = many;
        many = newMany;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__MANY, oldMany, many));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getCollectionType() {
        return collectionType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCollectionType(String newCollectionType) {
        String oldCollectionType = collectionType;
        collectionType = newCollectionType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__COLLECTION_TYPE, oldCollectionType, collectionType));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference getOpposite() {
        if (opposite != null && opposite.eIsProxy()) {
            InternalEObject oldOpposite = (InternalEObject)opposite;
            opposite = (Reference)eResolveProxy(oldOpposite);
            if (opposite != oldOpposite) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.REFERENCE__OPPOSITE, oldOpposite, opposite));
            }
        }
        return opposite;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference basicGetOpposite() {
        return opposite;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOpposite(Reference newOpposite) {
        Reference oldOpposite = opposite;
        opposite = newOpposite;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__OPPOSITE, oldOpposite, opposite));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject getTo() {
        if (to != null && to.eIsProxy()) {
            InternalEObject oldTo = (InternalEObject)to;
            to = (DomainObject)eResolveProxy(oldTo);
            if (to != oldTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptormetamodelPackage.REFERENCE__TO, oldTo, to));
            }
        }
        return to;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject basicGetTo() {
        return to;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTo(DomainObject newTo) {
        DomainObject oldTo = to;
        to = newTo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__TO, oldTo, to));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getCascade() {
        return cascade;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCascade(String newCascade) {
        String oldCascade = cascade;
        cascade = newCascade;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__CASCADE, oldCascade, cascade));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getOrderBy() {
        return orderBy;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOrderBy(String newOrderBy) {
        String oldOrderBy = orderBy;
        orderBy = newOrderBy;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__ORDER_BY, oldOrderBy, orderBy));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVisibility(String newVisibility) {
        String oldVisibility = visibility;
        visibility = newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__VISIBILITY, oldVisibility, visibility));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isChangeable() {
        return changeable;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setChangeable(boolean newChangeable) {
        boolean oldChangeable = changeable;
        changeable = newChangeable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__CHANGEABLE, oldChangeable, changeable));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject getFrom() {
        if (eContainerFeatureID() != SculptormetamodelPackage.REFERENCE__FROM) return null;
        return (DomainObject)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFrom(DomainObject newFrom, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFrom, SculptormetamodelPackage.REFERENCE__FROM, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFrom(DomainObject newFrom) {
        if (newFrom != eInternalContainer() || (eContainerFeatureID() != SculptormetamodelPackage.REFERENCE__FROM && newFrom != null)) {
            if (EcoreUtil.isAncestor(this, newFrom))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFrom != null)
                msgs = ((InternalEObject)newFrom).eInverseAdd(this, SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES, DomainObject.class, msgs);
            msgs = basicSetFrom(newFrom, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__FROM, newFrom, newFrom));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isRequired() {
        return required;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRequired(boolean newRequired) {
        boolean oldRequired = required;
        required = newRequired;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__REQUIRED, oldRequired, required));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFetch() {
        return fetch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFetch(String newFetch) {
        String oldFetch = fetch;
        fetch = newFetch;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__FETCH, oldFetch, fetch));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__CACHE, oldCache, cache));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNaturalKey() {
        return naturalKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNaturalKey(boolean newNaturalKey) {
        boolean oldNaturalKey = naturalKey;
        naturalKey = newNaturalKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__NATURAL_KEY, oldNaturalKey, naturalKey));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInverse() {
        return inverse;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInverse(boolean newInverse) {
        boolean oldInverse = inverse;
        inverse = newInverse;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__INVERSE, oldInverse, inverse));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNullable() {
        return nullable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNullable(boolean newNullable) {
        boolean oldNullable = nullable;
        nullable = newNullable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__NULLABLE, oldNullable, nullable));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDatabaseColumn() {
        return databaseColumn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatabaseColumn(String newDatabaseColumn) {
        String oldDatabaseColumn = databaseColumn;
        databaseColumn = newDatabaseColumn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__DATABASE_COLUMN, oldDatabaseColumn, databaseColumn));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__VALIDATE, oldValidate, validate));
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTransient() {
        return transient_;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTransient(boolean newTransient) {
        boolean oldTransient = transient_;
        transient_ = newTransient;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__TRANSIENT, oldTransient, transient_));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDatabaseJoinTable() {
        return databaseJoinTable;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatabaseJoinTable(String newDatabaseJoinTable) {
        String oldDatabaseJoinTable = databaseJoinTable;
        databaseJoinTable = newDatabaseJoinTable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_TABLE, oldDatabaseJoinTable, databaseJoinTable));
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDatabaseJoinColumn() {
        return databaseJoinColumn;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatabaseJoinColumn(String newDatabaseJoinColumn) {
        String oldDatabaseJoinColumn = databaseJoinColumn;
        databaseJoinColumn = newDatabaseJoinColumn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_COLUMN, oldDatabaseJoinColumn, databaseJoinColumn));
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.REFERENCE__FROM:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFrom((DomainObject)otherEnd, msgs);
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
            case SculptormetamodelPackage.REFERENCE__FROM:
                return basicSetFrom(null, msgs);
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
            case SculptormetamodelPackage.REFERENCE__FROM:
                return eInternalContainer().eInverseRemove(this, SculptormetamodelPackage.DOMAIN_OBJECT__REFERENCES, DomainObject.class, msgs);
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
            case SculptormetamodelPackage.REFERENCE__MANY:
                return isMany() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__COLLECTION_TYPE:
                return getCollectionType();
            case SculptormetamodelPackage.REFERENCE__OPPOSITE:
                if (resolve) return getOpposite();
                return basicGetOpposite();
            case SculptormetamodelPackage.REFERENCE__TO:
                if (resolve) return getTo();
                return basicGetTo();
            case SculptormetamodelPackage.REFERENCE__CASCADE:
                return getCascade();
            case SculptormetamodelPackage.REFERENCE__ORDER_BY:
                return getOrderBy();
            case SculptormetamodelPackage.REFERENCE__VISIBILITY:
                return getVisibility();
            case SculptormetamodelPackage.REFERENCE__CHANGEABLE:
                return isChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__FROM:
                return getFrom();
            case SculptormetamodelPackage.REFERENCE__REQUIRED:
                return isRequired() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__FETCH:
                return getFetch();
            case SculptormetamodelPackage.REFERENCE__CACHE:
                return isCache() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__NATURAL_KEY:
                return isNaturalKey() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__INVERSE:
                return isInverse() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__NULLABLE:
                return isNullable() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__DATABASE_COLUMN:
                return getDatabaseColumn();
            case SculptormetamodelPackage.REFERENCE__VALIDATE:
                return getValidate();
            case SculptormetamodelPackage.REFERENCE__TRANSIENT:
                return isTransient() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_TABLE:
                return getDatabaseJoinTable();
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_COLUMN:
                return getDatabaseJoinColumn();
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
            case SculptormetamodelPackage.REFERENCE__MANY:
                setMany(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__COLLECTION_TYPE:
                setCollectionType((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__OPPOSITE:
                setOpposite((Reference)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__TO:
                setTo((DomainObject)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__CASCADE:
                setCascade((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__ORDER_BY:
                setOrderBy((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__VISIBILITY:
                setVisibility((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__CHANGEABLE:
                setChangeable(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__FROM:
                setFrom((DomainObject)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__REQUIRED:
                setRequired(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__FETCH:
                setFetch((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__CACHE:
                setCache(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__NATURAL_KEY:
                setNaturalKey(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__INVERSE:
                setInverse(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__NULLABLE:
                setNullable(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__DATABASE_COLUMN:
                setDatabaseColumn((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__VALIDATE:
                setValidate((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__TRANSIENT:
                setTransient(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_TABLE:
                setDatabaseJoinTable((String)newValue);
                return;
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_COLUMN:
                setDatabaseJoinColumn((String)newValue);
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
            case SculptormetamodelPackage.REFERENCE__MANY:
                setMany(MANY_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__COLLECTION_TYPE:
                setCollectionType(COLLECTION_TYPE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__OPPOSITE:
                setOpposite((Reference)null);
                return;
            case SculptormetamodelPackage.REFERENCE__TO:
                setTo((DomainObject)null);
                return;
            case SculptormetamodelPackage.REFERENCE__CASCADE:
                setCascade(CASCADE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__ORDER_BY:
                setOrderBy(ORDER_BY_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__CHANGEABLE:
                setChangeable(CHANGEABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__FROM:
                setFrom((DomainObject)null);
                return;
            case SculptormetamodelPackage.REFERENCE__REQUIRED:
                setRequired(REQUIRED_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__FETCH:
                setFetch(FETCH_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__CACHE:
                setCache(CACHE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__NATURAL_KEY:
                setNaturalKey(NATURAL_KEY_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__INVERSE:
                setInverse(INVERSE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__NULLABLE:
                setNullable(NULLABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__DATABASE_COLUMN:
                setDatabaseColumn(DATABASE_COLUMN_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__VALIDATE:
                setValidate(VALIDATE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__TRANSIENT:
                setTransient(TRANSIENT_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_TABLE:
                setDatabaseJoinTable(DATABASE_JOIN_TABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_COLUMN:
                setDatabaseJoinColumn(DATABASE_JOIN_COLUMN_EDEFAULT);
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
            case SculptormetamodelPackage.REFERENCE__MANY:
                return many != MANY_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__COLLECTION_TYPE:
                return COLLECTION_TYPE_EDEFAULT == null ? collectionType != null : !COLLECTION_TYPE_EDEFAULT.equals(collectionType);
            case SculptormetamodelPackage.REFERENCE__OPPOSITE:
                return opposite != null;
            case SculptormetamodelPackage.REFERENCE__TO:
                return to != null;
            case SculptormetamodelPackage.REFERENCE__CASCADE:
                return CASCADE_EDEFAULT == null ? cascade != null : !CASCADE_EDEFAULT.equals(cascade);
            case SculptormetamodelPackage.REFERENCE__ORDER_BY:
                return ORDER_BY_EDEFAULT == null ? orderBy != null : !ORDER_BY_EDEFAULT.equals(orderBy);
            case SculptormetamodelPackage.REFERENCE__VISIBILITY:
                return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
            case SculptormetamodelPackage.REFERENCE__CHANGEABLE:
                return changeable != CHANGEABLE_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__FROM:
                return getFrom() != null;
            case SculptormetamodelPackage.REFERENCE__REQUIRED:
                return required != REQUIRED_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__FETCH:
                return FETCH_EDEFAULT == null ? fetch != null : !FETCH_EDEFAULT.equals(fetch);
            case SculptormetamodelPackage.REFERENCE__CACHE:
                return cache != CACHE_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__NATURAL_KEY:
                return naturalKey != NATURAL_KEY_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__INVERSE:
                return inverse != INVERSE_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__NULLABLE:
                return nullable != NULLABLE_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__DATABASE_COLUMN:
                return DATABASE_COLUMN_EDEFAULT == null ? databaseColumn != null : !DATABASE_COLUMN_EDEFAULT.equals(databaseColumn);
            case SculptormetamodelPackage.REFERENCE__VALIDATE:
                return VALIDATE_EDEFAULT == null ? validate != null : !VALIDATE_EDEFAULT.equals(validate);
            case SculptormetamodelPackage.REFERENCE__TRANSIENT:
                return transient_ != TRANSIENT_EDEFAULT;
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_TABLE:
                return DATABASE_JOIN_TABLE_EDEFAULT == null ? databaseJoinTable != null : !DATABASE_JOIN_TABLE_EDEFAULT.equals(databaseJoinTable);
            case SculptormetamodelPackage.REFERENCE__DATABASE_JOIN_COLUMN:
                return DATABASE_JOIN_COLUMN_EDEFAULT == null ? databaseJoinColumn != null : !DATABASE_JOIN_COLUMN_EDEFAULT.equals(databaseJoinColumn);
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
        result.append(" (many: ");
        result.append(many);
        result.append(", collectionType: ");
        result.append(collectionType);
        result.append(", cascade: ");
        result.append(cascade);
        result.append(", orderBy: ");
        result.append(orderBy);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(", changeable: ");
        result.append(changeable);
        result.append(", required: ");
        result.append(required);
        result.append(", fetch: ");
        result.append(fetch);
        result.append(", cache: ");
        result.append(cache);
        result.append(", naturalKey: ");
        result.append(naturalKey);
        result.append(", inverse: ");
        result.append(inverse);
        result.append(", nullable: ");
        result.append(nullable);
        result.append(", databaseColumn: ");
        result.append(databaseColumn);
        result.append(", validate: ");
        result.append(validate);
        result.append(", transient: ");
        result.append(transient_);
        result.append(", databaseJoinTable: ");
        result.append(databaseJoinTable);
        result.append(", databaseJoinColumn: ");
        result.append(databaseJoinColumn);
        result.append(')');
        return result.toString();
    }

} //ReferenceImpl