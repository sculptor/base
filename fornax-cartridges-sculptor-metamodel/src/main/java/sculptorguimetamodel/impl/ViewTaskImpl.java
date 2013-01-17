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

import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.ViewTask;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.ViewTaskImpl#getFindDOWith <em>Find DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewTaskImpl extends UserTaskImpl implements ViewTask {
	/**
     * The cached value of the '{@link #getFindDOWith() <em>Find DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFindDOWith()
     * @generated
     * @ordered
     */
	protected ServiceOperation findDOWith;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ViewTaskImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.VIEW_TASK;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation getFindDOWith() {
        if (findDOWith != null && findDOWith.eIsProxy()) {
            InternalEObject oldFindDOWith = (InternalEObject)findDOWith;
            findDOWith = (ServiceOperation)eResolveProxy(oldFindDOWith);
            if (findDOWith != oldFindDOWith) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.VIEW_TASK__FIND_DO_WITH, oldFindDOWith, findDOWith));
            }
        }
        return findDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation basicGetFindDOWith() {
        return findDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFindDOWith(ServiceOperation newFindDOWith) {
        ServiceOperation oldFindDOWith = findDOWith;
        findDOWith = newFindDOWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.VIEW_TASK__FIND_DO_WITH, oldFindDOWith, findDOWith));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.VIEW_TASK__FIND_DO_WITH:
                if (resolve) return getFindDOWith();
                return basicGetFindDOWith();
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
            case SculptorguimetamodelPackage.VIEW_TASK__FIND_DO_WITH:
                setFindDOWith((ServiceOperation)newValue);
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
            case SculptorguimetamodelPackage.VIEW_TASK__FIND_DO_WITH:
                setFindDOWith((ServiceOperation)null);
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
            case SculptorguimetamodelPackage.VIEW_TASK__FIND_DO_WITH:
                return findDOWith != null;
        }
        return super.eIsSet(featureID);
    }

} //ViewTaskImpl
