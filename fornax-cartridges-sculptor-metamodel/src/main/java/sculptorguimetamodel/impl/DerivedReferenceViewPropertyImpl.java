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

import sculptorguimetamodel.DerivedReferenceViewProperty;
import sculptorguimetamodel.ReferenceViewProperty;
import sculptorguimetamodel.SculptorguimetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived Reference View Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.DerivedReferenceViewPropertyImpl#getDerivedFrom <em>Derived From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedReferenceViewPropertyImpl extends ReferenceViewPropertyImpl implements DerivedReferenceViewProperty {
	/**
     * The cached value of the '{@link #getDerivedFrom() <em>Derived From</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDerivedFrom()
     * @generated
     * @ordered
     */
	protected ReferenceViewProperty derivedFrom;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DerivedReferenceViewPropertyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.DERIVED_REFERENCE_VIEW_PROPERTY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ReferenceViewProperty getDerivedFrom() {
        if (derivedFrom != null && derivedFrom.eIsProxy()) {
            InternalEObject oldDerivedFrom = (InternalEObject)derivedFrom;
            derivedFrom = (ReferenceViewProperty)eResolveProxy(oldDerivedFrom);
            if (derivedFrom != oldDerivedFrom) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM, oldDerivedFrom, derivedFrom));
            }
        }
        return derivedFrom;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ReferenceViewProperty basicGetDerivedFrom() {
        return derivedFrom;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDerivedFrom(ReferenceViewProperty newDerivedFrom) {
        ReferenceViewProperty oldDerivedFrom = derivedFrom;
        derivedFrom = newDerivedFrom;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM, oldDerivedFrom, derivedFrom));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM:
                if (resolve) return getDerivedFrom();
                return basicGetDerivedFrom();
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
            case SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM:
                setDerivedFrom((ReferenceViewProperty)newValue);
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
            case SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM:
                setDerivedFrom((ReferenceViewProperty)null);
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
            case SculptorguimetamodelPackage.DERIVED_REFERENCE_VIEW_PROPERTY__DERIVED_FROM:
                return derivedFrom != null;
        }
        return super.eIsSet(featureID);
    }

} //DerivedReferenceViewPropertyImpl
