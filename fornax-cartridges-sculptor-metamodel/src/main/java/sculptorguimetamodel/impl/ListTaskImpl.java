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

import sculptorguimetamodel.ListTask;
import sculptorguimetamodel.SculptorguimetamodelPackage;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.ListTaskImpl#getSearchDOWith <em>Search DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListTaskImpl extends UserTaskImpl implements ListTask {
	/**
     * The cached value of the '{@link #getSearchDOWith() <em>Search DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSearchDOWith()
     * @generated
     * @ordered
     */
	protected ServiceOperation searchDOWith;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ListTaskImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.LIST_TASK;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation getSearchDOWith() {
        if (searchDOWith != null && searchDOWith.eIsProxy()) {
            InternalEObject oldSearchDOWith = (InternalEObject)searchDOWith;
            searchDOWith = (ServiceOperation)eResolveProxy(oldSearchDOWith);
            if (searchDOWith != oldSearchDOWith) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.LIST_TASK__SEARCH_DO_WITH, oldSearchDOWith, searchDOWith));
            }
        }
        return searchDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation basicGetSearchDOWith() {
        return searchDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSearchDOWith(ServiceOperation newSearchDOWith) {
        ServiceOperation oldSearchDOWith = searchDOWith;
        searchDOWith = newSearchDOWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.LIST_TASK__SEARCH_DO_WITH, oldSearchDOWith, searchDOWith));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.LIST_TASK__SEARCH_DO_WITH:
                if (resolve) return getSearchDOWith();
                return basicGetSearchDOWith();
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
            case SculptorguimetamodelPackage.LIST_TASK__SEARCH_DO_WITH:
                setSearchDOWith((ServiceOperation)newValue);
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
            case SculptorguimetamodelPackage.LIST_TASK__SEARCH_DO_WITH:
                setSearchDOWith((ServiceOperation)null);
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
            case SculptorguimetamodelPackage.LIST_TASK__SEARCH_DO_WITH:
                return searchDOWith != null;
        }
        return super.eIsSet(featureID);
    }

} //ListTaskImpl
