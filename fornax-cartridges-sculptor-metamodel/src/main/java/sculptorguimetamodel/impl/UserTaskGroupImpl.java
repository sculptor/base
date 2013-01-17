/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.UserTaskGroup;
import sculptormetamodel.DomainObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Task Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskGroupImpl#getUserTasks <em>User Tasks</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskGroupImpl#getFor <em>For</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.UserTaskGroupImpl#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserTaskGroupImpl extends EObjectImpl implements UserTaskGroup {
	/**
     * The cached value of the '{@link #getUserTasks() <em>User Tasks</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUserTasks()
     * @generated
     * @ordered
     */
	protected EList userTasks;

	/**
     * The cached value of the '{@link #getFor() <em>For</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFor()
     * @generated
     * @ordered
     */
    protected DomainObject for_;
    /**
     * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModule()
     * @generated
     * @ordered
     */
    protected GuiModule module;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected UserTaskGroupImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.USER_TASK_GROUP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getUserTasks() {
        if (userTasks == null) {
            userTasks = new EObjectResolvingEList(UserTask.class, this, SculptorguimetamodelPackage.USER_TASK_GROUP__USER_TASKS);
        }
        return userTasks;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject getFor() {
        if (for_ != null && for_.eIsProxy()) {
            InternalEObject oldFor = (InternalEObject)for_;
            for_ = (DomainObject)eResolveProxy(oldFor);
            if (for_ != oldFor) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.USER_TASK_GROUP__FOR, oldFor, for_));
            }
        }
        return for_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject basicGetFor() {
        return for_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFor(DomainObject newFor) {
        DomainObject oldFor = for_;
        for_ = newFor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK_GROUP__FOR, oldFor, for_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GuiModule getModule() {
        if (module != null && module.eIsProxy()) {
            InternalEObject oldModule = (InternalEObject)module;
            module = (GuiModule)eResolveProxy(oldModule);
            if (module != oldModule) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.USER_TASK_GROUP__MODULE, oldModule, module));
            }
        }
        return module;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GuiModule basicGetModule() {
        return module;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModule(GuiModule newModule) {
        GuiModule oldModule = module;
        module = newModule;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.USER_TASK_GROUP__MODULE, oldModule, module));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.USER_TASK_GROUP__USER_TASKS:
                return getUserTasks();
            case SculptorguimetamodelPackage.USER_TASK_GROUP__FOR:
                if (resolve) return getFor();
                return basicGetFor();
            case SculptorguimetamodelPackage.USER_TASK_GROUP__MODULE:
                if (resolve) return getModule();
                return basicGetModule();
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
            case SculptorguimetamodelPackage.USER_TASK_GROUP__USER_TASKS:
                getUserTasks().clear();
                getUserTasks().addAll((Collection)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK_GROUP__FOR:
                setFor((DomainObject)newValue);
                return;
            case SculptorguimetamodelPackage.USER_TASK_GROUP__MODULE:
                setModule((GuiModule)newValue);
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
            case SculptorguimetamodelPackage.USER_TASK_GROUP__USER_TASKS:
                getUserTasks().clear();
                return;
            case SculptorguimetamodelPackage.USER_TASK_GROUP__FOR:
                setFor((DomainObject)null);
                return;
            case SculptorguimetamodelPackage.USER_TASK_GROUP__MODULE:
                setModule((GuiModule)null);
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
            case SculptorguimetamodelPackage.USER_TASK_GROUP__USER_TASKS:
                return userTasks != null && !userTasks.isEmpty();
            case SculptorguimetamodelPackage.USER_TASK_GROUP__FOR:
                return for_ != null;
            case SculptorguimetamodelPackage.USER_TASK_GROUP__MODULE:
                return module != null;
        }
        return super.eIsSet(featureID);
    }

} //UserTaskGroupImpl
