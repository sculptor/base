/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sculptorguimetamodel.BasicTypeEnumViewProperty;
import sculptorguimetamodel.SculptorguimetamodelPackage;

import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Type Enum View Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.BasicTypeEnumViewPropertyImpl#getBasicTypeReference <em>Basic Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicTypeEnumViewPropertyImpl extends EnumViewPropertyImpl implements BasicTypeEnumViewProperty {
	/**
     * The cached value of the '{@link #getBasicTypeReference() <em>Basic Type Reference</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBasicTypeReference()
     * @generated
     * @ordered
     */
	protected Reference basicTypeReference;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BasicTypeEnumViewPropertyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.BASIC_TYPE_ENUM_VIEW_PROPERTY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference getBasicTypeReference() {
        if (basicTypeReference != null && basicTypeReference.eIsProxy()) {
            InternalEObject oldBasicTypeReference = (InternalEObject)basicTypeReference;
            basicTypeReference = (Reference)eResolveProxy(oldBasicTypeReference);
            if (basicTypeReference != oldBasicTypeReference) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE, oldBasicTypeReference, basicTypeReference));
            }
        }
        return basicTypeReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference basicGetBasicTypeReference() {
        return basicTypeReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBasicTypeReference(Reference newBasicTypeReference) {
        Reference oldBasicTypeReference = basicTypeReference;
        basicTypeReference = newBasicTypeReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE, oldBasicTypeReference, basicTypeReference));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE:
                if (resolve) return getBasicTypeReference();
                return basicGetBasicTypeReference();
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
            case SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE:
                setBasicTypeReference((Reference)newValue);
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
            case SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE:
                setBasicTypeReference((Reference)null);
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
            case SculptorguimetamodelPackage.BASIC_TYPE_ENUM_VIEW_PROPERTY__BASIC_TYPE_REFERENCE:
                return basicTypeReference != null;
        }
        return super.eIsSet(featureID);
    }

} //BasicTypeEnumViewPropertyImpl
