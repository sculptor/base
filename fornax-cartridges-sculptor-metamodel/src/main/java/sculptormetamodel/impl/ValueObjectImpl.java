/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.ValueObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.ValueObjectImpl#isImmutable <em>Immutable</em>}</li>
 *   <li>{@link sculptormetamodel.impl.ValueObjectImpl#isPersistent <em>Persistent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueObjectImpl extends DomainObjectImpl implements ValueObject {
    /**
     * The default value of the '{@link #isImmutable() <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isImmutable()
     * @generated
     * @ordered
     */
	protected static final boolean IMMUTABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isImmutable() <em>Immutable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isImmutable()
     * @generated
     * @ordered
     */
	protected boolean immutable = IMMUTABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isPersistent() <em>Persistent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isPersistent()
     * @generated
     * @ordered
     */
	protected static final boolean PERSISTENT_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isPersistent() <em>Persistent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isPersistent()
     * @generated
     * @ordered
     */
	protected boolean persistent = PERSISTENT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ValueObjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.VALUE_OBJECT;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isImmutable() {
        return immutable;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImmutable(boolean newImmutable) {
        boolean oldImmutable = immutable;
        immutable = newImmutable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.VALUE_OBJECT__IMMUTABLE, oldImmutable, immutable));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isPersistent() {
        return persistent;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPersistent(boolean newPersistent) {
        boolean oldPersistent = persistent;
        persistent = newPersistent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.VALUE_OBJECT__PERSISTENT, oldPersistent, persistent));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.VALUE_OBJECT__IMMUTABLE:
                return isImmutable() ? Boolean.TRUE : Boolean.FALSE;
            case SculptormetamodelPackage.VALUE_OBJECT__PERSISTENT:
                return isPersistent() ? Boolean.TRUE : Boolean.FALSE;
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
            case SculptormetamodelPackage.VALUE_OBJECT__IMMUTABLE:
                setImmutable(((Boolean)newValue).booleanValue());
                return;
            case SculptormetamodelPackage.VALUE_OBJECT__PERSISTENT:
                setPersistent(((Boolean)newValue).booleanValue());
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
            case SculptormetamodelPackage.VALUE_OBJECT__IMMUTABLE:
                setImmutable(IMMUTABLE_EDEFAULT);
                return;
            case SculptormetamodelPackage.VALUE_OBJECT__PERSISTENT:
                setPersistent(PERSISTENT_EDEFAULT);
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
            case SculptormetamodelPackage.VALUE_OBJECT__IMMUTABLE:
                return immutable != IMMUTABLE_EDEFAULT;
            case SculptormetamodelPackage.VALUE_OBJECT__PERSISTENT:
                return persistent != PERSISTENT_EDEFAULT;
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
        result.append(" (immutable: ");
        result.append(immutable);
        result.append(", persistent: ");
        result.append(persistent);
        result.append(')');
        return result.toString();
    }

} //ValueObjectImpl