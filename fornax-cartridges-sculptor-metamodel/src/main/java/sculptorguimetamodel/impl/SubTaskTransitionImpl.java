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
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.UserTask;

import sculptormetamodel.Reference;

import sculptormetamodel.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Task Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.SubTaskTransitionImpl#getTo <em>To</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.SubTaskTransitionImpl#getForReference <em>For Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.SubTaskTransitionImpl#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubTaskTransitionImpl extends NamedElementImpl implements SubTaskTransition {
	/**
     * The cached value of the '{@link #getTo() <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
	protected UserTask to;

	/**
     * The cached value of the '{@link #getForReference() <em>For Reference</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getForReference()
     * @generated
     * @ordered
     */
	protected Reference forReference;

	/**
     * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFrom()
     * @generated
     * @ordered
     */
	protected UserTask from;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SubTaskTransitionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.SUB_TASK_TRANSITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UserTask getTo() {
        if (to != null && to.eIsProxy()) {
            InternalEObject oldTo = (InternalEObject)to;
            to = (UserTask)eResolveProxy(oldTo);
            if (to != oldTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.SUB_TASK_TRANSITION__TO, oldTo, to));
            }
        }
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UserTask basicGetTo() {
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTo(UserTask newTo) {
        UserTask oldTo = to;
        to = newTo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.SUB_TASK_TRANSITION__TO, oldTo, to));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference getForReference() {
        if (forReference != null && forReference.eIsProxy()) {
            InternalEObject oldForReference = (InternalEObject)forReference;
            forReference = (Reference)eResolveProxy(oldForReference);
            if (forReference != oldForReference) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FOR_REFERENCE, oldForReference, forReference));
            }
        }
        return forReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference basicGetForReference() {
        return forReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setForReference(Reference newForReference) {
        Reference oldForReference = forReference;
        forReference = newForReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FOR_REFERENCE, oldForReference, forReference));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UserTask getFrom() {
        if (from != null && from.eIsProxy()) {
            InternalEObject oldFrom = (InternalEObject)from;
            from = (UserTask)eResolveProxy(oldFrom);
            if (from != oldFrom) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FROM, oldFrom, from));
            }
        }
        return from;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UserTask basicGetFrom() {
        return from;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFrom(UserTask newFrom) {
        UserTask oldFrom = from;
        from = newFrom;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FROM, oldFrom, from));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__TO:
                if (resolve) return getTo();
                return basicGetTo();
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FOR_REFERENCE:
                if (resolve) return getForReference();
                return basicGetForReference();
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FROM:
                if (resolve) return getFrom();
                return basicGetFrom();
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
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__TO:
                setTo((UserTask)newValue);
                return;
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FOR_REFERENCE:
                setForReference((Reference)newValue);
                return;
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FROM:
                setFrom((UserTask)newValue);
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
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__TO:
                setTo((UserTask)null);
                return;
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FOR_REFERENCE:
                setForReference((Reference)null);
                return;
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FROM:
                setFrom((UserTask)null);
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
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__TO:
                return to != null;
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FOR_REFERENCE:
                return forReference != null;
            case SculptorguimetamodelPackage.SUB_TASK_TRANSITION__FROM:
                return from != null;
        }
        return super.eIsSet(featureID);
    }

} //SubTaskTransitionImpl
