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

import sculptorguimetamodel.DeleteTask;
import sculptorguimetamodel.SculptorguimetamodelPackage;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.DeleteTaskImpl#getFindDOWith <em>Find DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.DeleteTaskImpl#getDeleteDOWith <em>Delete DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeleteTaskImpl extends UserTaskImpl implements DeleteTask {
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
     * The cached value of the '{@link #getDeleteDOWith() <em>Delete DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDeleteDOWith()
     * @generated
     * @ordered
     */
	protected ServiceOperation deleteDOWith;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DeleteTaskImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.DELETE_TASK;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.DELETE_TASK__FIND_DO_WITH, oldFindDOWith, findDOWith));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.DELETE_TASK__FIND_DO_WITH, oldFindDOWith, findDOWith));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation getDeleteDOWith() {
        if (deleteDOWith != null && deleteDOWith.eIsProxy()) {
            InternalEObject oldDeleteDOWith = (InternalEObject)deleteDOWith;
            deleteDOWith = (ServiceOperation)eResolveProxy(oldDeleteDOWith);
            if (deleteDOWith != oldDeleteDOWith) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.DELETE_TASK__DELETE_DO_WITH, oldDeleteDOWith, deleteDOWith));
            }
        }
        return deleteDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation basicGetDeleteDOWith() {
        return deleteDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDeleteDOWith(ServiceOperation newDeleteDOWith) {
        ServiceOperation oldDeleteDOWith = deleteDOWith;
        deleteDOWith = newDeleteDOWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.DELETE_TASK__DELETE_DO_WITH, oldDeleteDOWith, deleteDOWith));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.DELETE_TASK__FIND_DO_WITH:
                if (resolve) return getFindDOWith();
                return basicGetFindDOWith();
            case SculptorguimetamodelPackage.DELETE_TASK__DELETE_DO_WITH:
                if (resolve) return getDeleteDOWith();
                return basicGetDeleteDOWith();
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
            case SculptorguimetamodelPackage.DELETE_TASK__FIND_DO_WITH:
                setFindDOWith((ServiceOperation)newValue);
                return;
            case SculptorguimetamodelPackage.DELETE_TASK__DELETE_DO_WITH:
                setDeleteDOWith((ServiceOperation)newValue);
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
            case SculptorguimetamodelPackage.DELETE_TASK__FIND_DO_WITH:
                setFindDOWith((ServiceOperation)null);
                return;
            case SculptorguimetamodelPackage.DELETE_TASK__DELETE_DO_WITH:
                setDeleteDOWith((ServiceOperation)null);
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
            case SculptorguimetamodelPackage.DELETE_TASK__FIND_DO_WITH:
                return findDOWith != null;
            case SculptorguimetamodelPackage.DELETE_TASK__DELETE_DO_WITH:
                return deleteDOWith != null;
        }
        return super.eIsSet(featureID);
    }

} //DeleteTaskImpl
