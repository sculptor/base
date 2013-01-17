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
import sculptorguimetamodel.UpdateTask;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.UpdateTaskImpl#getFindDOWith <em>Find DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UpdateTaskImpl#getUpdateDOWith <em>Update DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UpdateTaskImpl#getPopulateDOWith <em>Populate DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateTaskImpl extends UserTaskImpl implements UpdateTask {
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
     * The cached value of the '{@link #getUpdateDOWith() <em>Update DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUpdateDOWith()
     * @generated
     * @ordered
     */
	protected ServiceOperation updateDOWith;

	/**
     * The cached value of the '{@link #getPopulateDOWith() <em>Populate DO With</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPopulateDOWith()
     * @generated
     * @ordered
     */
    protected ServiceOperation populateDOWith;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected UpdateTaskImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.UPDATE_TASK;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.UPDATE_TASK__FIND_DO_WITH, oldFindDOWith, findDOWith));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.UPDATE_TASK__FIND_DO_WITH, oldFindDOWith, findDOWith));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation getUpdateDOWith() {
        if (updateDOWith != null && updateDOWith.eIsProxy()) {
            InternalEObject oldUpdateDOWith = (InternalEObject)updateDOWith;
            updateDOWith = (ServiceOperation)eResolveProxy(oldUpdateDOWith);
            if (updateDOWith != oldUpdateDOWith) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.UPDATE_TASK__UPDATE_DO_WITH, oldUpdateDOWith, updateDOWith));
            }
        }
        return updateDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation basicGetUpdateDOWith() {
        return updateDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUpdateDOWith(ServiceOperation newUpdateDOWith) {
        ServiceOperation oldUpdateDOWith = updateDOWith;
        updateDOWith = newUpdateDOWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.UPDATE_TASK__UPDATE_DO_WITH, oldUpdateDOWith, updateDOWith));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceOperation getPopulateDOWith() {
        if (populateDOWith != null && populateDOWith.eIsProxy()) {
            InternalEObject oldPopulateDOWith = (InternalEObject)populateDOWith;
            populateDOWith = (ServiceOperation)eResolveProxy(oldPopulateDOWith);
            if (populateDOWith != oldPopulateDOWith) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.UPDATE_TASK__POPULATE_DO_WITH, oldPopulateDOWith, populateDOWith));
            }
        }
        return populateDOWith;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceOperation basicGetPopulateDOWith() {
        return populateDOWith;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPopulateDOWith(ServiceOperation newPopulateDOWith) {
        ServiceOperation oldPopulateDOWith = populateDOWith;
        populateDOWith = newPopulateDOWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.UPDATE_TASK__POPULATE_DO_WITH, oldPopulateDOWith, populateDOWith));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.UPDATE_TASK__FIND_DO_WITH:
                if (resolve) return getFindDOWith();
                return basicGetFindDOWith();
            case SculptorguimetamodelPackage.UPDATE_TASK__UPDATE_DO_WITH:
                if (resolve) return getUpdateDOWith();
                return basicGetUpdateDOWith();
            case SculptorguimetamodelPackage.UPDATE_TASK__POPULATE_DO_WITH:
                if (resolve) return getPopulateDOWith();
                return basicGetPopulateDOWith();
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
            case SculptorguimetamodelPackage.UPDATE_TASK__FIND_DO_WITH:
                setFindDOWith((ServiceOperation)newValue);
                return;
            case SculptorguimetamodelPackage.UPDATE_TASK__UPDATE_DO_WITH:
                setUpdateDOWith((ServiceOperation)newValue);
                return;
            case SculptorguimetamodelPackage.UPDATE_TASK__POPULATE_DO_WITH:
                setPopulateDOWith((ServiceOperation)newValue);
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
            case SculptorguimetamodelPackage.UPDATE_TASK__FIND_DO_WITH:
                setFindDOWith((ServiceOperation)null);
                return;
            case SculptorguimetamodelPackage.UPDATE_TASK__UPDATE_DO_WITH:
                setUpdateDOWith((ServiceOperation)null);
                return;
            case SculptorguimetamodelPackage.UPDATE_TASK__POPULATE_DO_WITH:
                setPopulateDOWith((ServiceOperation)null);
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
            case SculptorguimetamodelPackage.UPDATE_TASK__FIND_DO_WITH:
                return findDOWith != null;
            case SculptorguimetamodelPackage.UPDATE_TASK__UPDATE_DO_WITH:
                return updateDOWith != null;
            case SculptorguimetamodelPackage.UPDATE_TASK__POPULATE_DO_WITH:
                return populateDOWith != null;
        }
        return super.eIsSet(featureID);
    }

} //UpdateTaskImpl
