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

import sculptorguimetamodel.CreateTask;
import sculptorguimetamodel.SculptorguimetamodelPackage;

import sculptormetamodel.ServiceOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.CreateTaskImpl#getCreateDOWith <em>Create DO With</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.CreateTaskImpl#getPopulateDOWith <em>Populate DO With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateTaskImpl extends UserTaskImpl implements CreateTask {
	/**
     * The cached value of the '{@link #getCreateDOWith() <em>Create DO With</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCreateDOWith()
     * @generated
     * @ordered
     */
	protected ServiceOperation createDOWith;

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
	protected CreateTaskImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.CREATE_TASK;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation getCreateDOWith() {
        if (createDOWith != null && createDOWith.eIsProxy()) {
            InternalEObject oldCreateDOWith = (InternalEObject)createDOWith;
            createDOWith = (ServiceOperation)eResolveProxy(oldCreateDOWith);
            if (createDOWith != oldCreateDOWith) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.CREATE_TASK__CREATE_DO_WITH, oldCreateDOWith, createDOWith));
            }
        }
        return createDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceOperation basicGetCreateDOWith() {
        return createDOWith;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCreateDOWith(ServiceOperation newCreateDOWith) {
        ServiceOperation oldCreateDOWith = createDOWith;
        createDOWith = newCreateDOWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.CREATE_TASK__CREATE_DO_WITH, oldCreateDOWith, createDOWith));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.CREATE_TASK__POPULATE_DO_WITH, oldPopulateDOWith, populateDOWith));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.CREATE_TASK__POPULATE_DO_WITH, oldPopulateDOWith, populateDOWith));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.CREATE_TASK__CREATE_DO_WITH:
                if (resolve) return getCreateDOWith();
                return basicGetCreateDOWith();
            case SculptorguimetamodelPackage.CREATE_TASK__POPULATE_DO_WITH:
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
            case SculptorguimetamodelPackage.CREATE_TASK__CREATE_DO_WITH:
                setCreateDOWith((ServiceOperation)newValue);
                return;
            case SculptorguimetamodelPackage.CREATE_TASK__POPULATE_DO_WITH:
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
            case SculptorguimetamodelPackage.CREATE_TASK__CREATE_DO_WITH:
                setCreateDOWith((ServiceOperation)null);
                return;
            case SculptorguimetamodelPackage.CREATE_TASK__POPULATE_DO_WITH:
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
            case SculptorguimetamodelPackage.CREATE_TASK__CREATE_DO_WITH:
                return createDOWith != null;
            case SculptorguimetamodelPackage.CREATE_TASK__POPULATE_DO_WITH:
                return populateDOWith != null;
        }
        return super.eIsSet(featureID);
    }

} //CreateTaskImpl
