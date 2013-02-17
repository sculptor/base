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
import org.eclipse.emf.ecore.util.InternalEList;

import sculptormetamodel.EnumValue;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.EnumImpl#getValues <em>Values</em>}</li>
 *   <li>{@link sculptormetamodel.impl.EnumImpl#isOrdinal <em>Ordinal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumImpl extends DomainObjectImpl implements sculptormetamodel.Enum {
	/**
     * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
	protected EList values;

	/**
     * The default value of the '{@link #isOrdinal() <em>Ordinal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOrdinal()
     * @generated
     * @ordered
     */
	protected static final boolean ORDINAL_EDEFAULT = false;
	/**
     * The cached value of the '{@link #isOrdinal() <em>Ordinal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOrdinal()
     * @generated
     * @ordered
     */
	protected boolean ordinal = ORDINAL_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EnumImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.ENUM;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getValues() {
        if (values == null) {
            values = new EObjectContainmentEList(EnumValue.class, this, SculptormetamodelPackage.ENUM__VALUES);
        }
        return values;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isOrdinal() {
        return ordinal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOrdinal(boolean newOrdinal) {
        boolean oldOrdinal = ordinal;
        ordinal = newOrdinal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.ENUM__ORDINAL, oldOrdinal, ordinal));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptormetamodelPackage.ENUM__VALUES:
                return ((InternalEList)getValues()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.ENUM__VALUES:
                return getValues();
            case SculptormetamodelPackage.ENUM__ORDINAL:
                return isOrdinal() ? Boolean.TRUE : Boolean.FALSE;
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
            case SculptormetamodelPackage.ENUM__VALUES:
                getValues().clear();
                getValues().addAll((Collection)newValue);
                return;
            case SculptormetamodelPackage.ENUM__ORDINAL:
                setOrdinal(((Boolean)newValue).booleanValue());
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
            case SculptormetamodelPackage.ENUM__VALUES:
                getValues().clear();
                return;
            case SculptormetamodelPackage.ENUM__ORDINAL:
                setOrdinal(ORDINAL_EDEFAULT);
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
            case SculptormetamodelPackage.ENUM__VALUES:
                return values != null && !values.isEmpty();
            case SculptormetamodelPackage.ENUM__ORDINAL:
                return ordinal != ORDINAL_EDEFAULT;
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
        result.append(" (ordinal: ");
        result.append(ordinal);
        result.append(')');
        return result.toString();
    }

} //EnumImpl
