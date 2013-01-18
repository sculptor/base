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
import sculptormetamodel.Attribute;
import sculptormetamodel.DomainObject;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#isNaturalKey <em>Natural Key</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#isIndex <em>Index</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#getDatabaseColumn <em>Database Column</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#getValidate <em>Validate</em>}</li>
 *   <li>{@link sculptormetamodel.impl.AttributeImpl#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends TypedElementImpl implements Attribute {
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
     * The default value of the '{@link #getDatabaseType() <em>Database Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDatabaseType()
     * @generated
     * @ordered
     */
	protected static final String DATABASE_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDatabaseType() <em>Database Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDatabaseType()
     * @generated
     * @ordered
     */
	protected String databaseType = DATABASE_TYPE_EDEFAULT;

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
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected static final String LENGTH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected String length = LENGTH_EDEFAULT;

    /**
     * The default value of the '{@link #isIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIndex()
     * @generated
     * @ordered
     */
    protected static final boolean INDEX_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIndex()
     * @generated
     * @ordered
     */
    protected boolean index = INDEX_EDEFAULT;

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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.ATTRIBUTE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__CHANGEABLE, oldChangeable, changeable));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDatabaseType() {
        return databaseType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDatabaseType(String newDatabaseType) {
        String oldDatabaseType = databaseType;
        databaseType = newDatabaseType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__DATABASE_TYPE, oldDatabaseType, databaseType));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__NULLABLE, oldNullable, nullable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__NATURAL_KEY, oldNaturalKey, naturalKey));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__VISIBILITY, oldVisibility, visibility));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__REQUIRED, oldRequired, required));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLength() {
        return length;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLength(String newLength) {
        String oldLength = length;
        length = newLength;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__LENGTH, oldLength, length));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIndex() {
        return index;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIndex(boolean newIndex) {
        boolean oldIndex = index;
        index = newIndex;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__INDEX, oldIndex, index));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__DATABASE_COLUMN, oldDatabaseColumn, databaseColumn));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__VALIDATE, oldValidate, validate));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ATTRIBUTE__TRANSIENT, oldTransient, transient_));
    }

                /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.ATTRIBUTE__CHANGEABLE:
                return isChangeable() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_TYPE:
                return getDatabaseType();
            case SculptormetamodelPackage.ATTRIBUTE__NULLABLE:
                return isNullable() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.ATTRIBUTE__NATURAL_KEY:
                return isNaturalKey() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.ATTRIBUTE__VISIBILITY:
                return getVisibility();
            case SculptormetamodelPackage.ATTRIBUTE__REQUIRED:
                return isRequired() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.ATTRIBUTE__LENGTH:
                return getLength();
            case SculptormetamodelPackage.ATTRIBUTE__INDEX:
                return isIndex() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_COLUMN:
                return getDatabaseColumn();
            case SculptormetamodelPackage.ATTRIBUTE__VALIDATE:
                return getValidate();
            case SculptormetamodelPackage.ATTRIBUTE__TRANSIENT:
                return isTransient() ? Boolean.TRUE : Boolean.FALSE;
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
            case SculptormetamodelPackage.ATTRIBUTE__CHANGEABLE:
                setChangeable(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_TYPE:
                setDatabaseType((String)newValue);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__NULLABLE:
                setNullable(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.ATTRIBUTE__NATURAL_KEY:
                setNaturalKey(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.ATTRIBUTE__VISIBILITY:
                setVisibility((String)newValue);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__REQUIRED:
                setRequired(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.ATTRIBUTE__LENGTH:
                setLength((String)newValue);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__INDEX:
                setIndex(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_COLUMN:
                setDatabaseColumn((String)newValue);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__VALIDATE:
                setValidate((String)newValue);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__TRANSIENT:
                setTransient(((Boolean)newValue).booleanValue());
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
            case SculptormetamodelPackage.ATTRIBUTE__CHANGEABLE:
                setChangeable(CHANGEABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_TYPE:
                setDatabaseType(DATABASE_TYPE_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__NULLABLE:
                setNullable(NULLABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__NATURAL_KEY:
                setNaturalKey(NATURAL_KEY_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__REQUIRED:
                setRequired(REQUIRED_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__LENGTH:
                setLength(LENGTH_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__INDEX:
                setIndex(INDEX_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_COLUMN:
                setDatabaseColumn(DATABASE_COLUMN_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__VALIDATE:
                setValidate(VALIDATE_EDEFAULT);
                return;
            case SculptormetamodelPackage.ATTRIBUTE__TRANSIENT:
                setTransient(TRANSIENT_EDEFAULT);
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
            case SculptormetamodelPackage.ATTRIBUTE__CHANGEABLE:
                return changeable != CHANGEABLE_EDEFAULT;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_TYPE:
                return DATABASE_TYPE_EDEFAULT == null ? databaseType != null : !DATABASE_TYPE_EDEFAULT.equals(databaseType);
            case SculptormetamodelPackage.ATTRIBUTE__NULLABLE:
                return nullable != NULLABLE_EDEFAULT;
            case SculptormetamodelPackage.ATTRIBUTE__NATURAL_KEY:
                return naturalKey != NATURAL_KEY_EDEFAULT;
            case SculptormetamodelPackage.ATTRIBUTE__VISIBILITY:
                return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
            case SculptormetamodelPackage.ATTRIBUTE__REQUIRED:
                return required != REQUIRED_EDEFAULT;
            case SculptormetamodelPackage.ATTRIBUTE__LENGTH:
                return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
            case SculptormetamodelPackage.ATTRIBUTE__INDEX:
                return index != INDEX_EDEFAULT;
            case SculptormetamodelPackage.ATTRIBUTE__DATABASE_COLUMN:
                return DATABASE_COLUMN_EDEFAULT == null ? databaseColumn != null : !DATABASE_COLUMN_EDEFAULT.equals(databaseColumn);
            case SculptormetamodelPackage.ATTRIBUTE__VALIDATE:
                return VALIDATE_EDEFAULT == null ? validate != null : !VALIDATE_EDEFAULT.equals(validate);
            case SculptormetamodelPackage.ATTRIBUTE__TRANSIENT:
                return transient_ != TRANSIENT_EDEFAULT;
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
        result.append(" (changeable: ");
        result.append(changeable);
        result.append(", databaseType: ");
        result.append(databaseType);
        result.append(", nullable: ");
        result.append(nullable);
        result.append(", naturalKey: ");
        result.append(naturalKey);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(", required: ");
        result.append(required);
        result.append(", length: ");
        result.append(length);
        result.append(", index: ");
        result.append(index);
        result.append(", databaseColumn: ");
        result.append(databaseColumn);
        result.append(", validate: ");
        result.append(validate);
        result.append(", transient: ");
        result.append(transient_);
        result.append(')');
        return result.toString();
    }

} //AttributeImpl