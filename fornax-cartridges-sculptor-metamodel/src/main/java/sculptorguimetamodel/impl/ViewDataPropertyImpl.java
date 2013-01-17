/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.ViewDataProperty;

import sculptormetamodel.impl.NamedElementImpl;
import sculptormetamodel.Attribute;
import sculptormetamodel.Reference;

import sculptormetamodel.impl.TypedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Data Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.ViewDataPropertyImpl#getUserTask <em>User Task</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.ViewDataPropertyImpl#getMessageKey <em>Message Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewDataPropertyImpl extends NamedElementImpl implements ViewDataProperty {
	/**
     * The default value of the '{@link #getMessageKey() <em>Message Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageKey()
     * @generated
     * @ordered
     */
    protected static final String MESSAGE_KEY_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getMessageKey() <em>Message Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageKey()
     * @generated
     * @ordered
     */
    protected String messageKey = MESSAGE_KEY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ViewDataPropertyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.VIEW_DATA_PROPERTY;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserTask getUserTask() {
        if (eContainerFeatureID() != SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK) return null;
        return (UserTask)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUserTask(UserTask newUserTask, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newUserTask, SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUserTask(UserTask newUserTask) {
        if (newUserTask != eInternalContainer() || (eContainerFeatureID() != SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK && newUserTask != null)) {
            if (EcoreUtil.isAncestor(this, newUserTask))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newUserTask != null)
                msgs = ((InternalEObject)newUserTask).eInverseAdd(this, SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES, UserTask.class, msgs);
            msgs = basicSetUserTask(newUserTask, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK, newUserTask, newUserTask));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMessageKey(String newMessageKey) {
        String oldMessageKey = messageKey;
        messageKey = newMessageKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__MESSAGE_KEY, oldMessageKey, messageKey));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetUserTask((UserTask)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                return basicSetUserTask(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                return eInternalContainer().eInverseRemove(this, SculptorguimetamodelPackage.USER_TASK__VIEW_PROPERTIES, UserTask.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                return getUserTask();
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__MESSAGE_KEY:
                return getMessageKey();
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
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                setUserTask((UserTask)newValue);
                return;
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__MESSAGE_KEY:
                setMessageKey((String)newValue);
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
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                setUserTask((UserTask)null);
                return;
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__MESSAGE_KEY:
                setMessageKey(MESSAGE_KEY_EDEFAULT);
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
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__USER_TASK:
                return getUserTask() != null;
            case SculptorguimetamodelPackage.VIEW_DATA_PROPERTY__MESSAGE_KEY:
                return MESSAGE_KEY_EDEFAULT == null ? messageKey != null : !MESSAGE_KEY_EDEFAULT.equals(messageKey);
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
        result.append(" (messageKey: ");
        result.append(messageKey);
        result.append(')');
        return result.toString();
    }

} //ViewDataPropertyImpl
