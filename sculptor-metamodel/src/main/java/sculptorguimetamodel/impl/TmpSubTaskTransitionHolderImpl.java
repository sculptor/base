/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.TmpReferenceHolder;
import sculptorguimetamodel.TmpSubTaskTransitionHolder;

import sculptormetamodel.DomainObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmp Sub Task Transition Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl#getToTaskType <em>To Task Type</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl#getTo <em>To</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.TmpSubTaskTransitionHolderImpl#getReferenceHoler <em>Reference Holer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TmpSubTaskTransitionHolderImpl extends EObjectImpl implements TmpSubTaskTransitionHolder {
	/**
     * The default value of the '{@link #getToTaskType() <em>To Task Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getToTaskType()
     * @generated
     * @ordered
     */
	protected static final String TO_TASK_TYPE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getToTaskType() <em>To Task Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getToTaskType()
     * @generated
     * @ordered
     */
	protected String toTaskType = TO_TASK_TYPE_EDEFAULT;

	/**
     * The cached value of the '{@link #getTo() <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
	protected DomainObject to;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TmpSubTaskTransitionHolderImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.TMP_SUB_TASK_TRANSITION_HOLDER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getToTaskType() {
        return toTaskType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setToTaskType(String newToTaskType) {
        String oldToTaskType = toTaskType;
        toTaskType = newToTaskType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE, oldToTaskType, toTaskType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject getTo() {
        if (to != null && to.eIsProxy()) {
            InternalEObject oldTo = (InternalEObject)to;
            to = (DomainObject)eResolveProxy(oldTo);
            if (to != oldTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO, oldTo, to));
            }
        }
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DomainObject basicGetTo() {
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTo(DomainObject newTo) {
        DomainObject oldTo = to;
        to = newTo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO, oldTo, to));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TmpReferenceHolder getReferenceHoler() {
        if (eContainerFeatureID() != SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER) return null;
        return (TmpReferenceHolder)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetReferenceHoler(TmpReferenceHolder newReferenceHoler, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReferenceHoler, SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setReferenceHoler(TmpReferenceHolder newReferenceHoler) {
        if (newReferenceHoler != eInternalContainer() || (eContainerFeatureID() != SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER && newReferenceHoler != null)) {
            if (EcoreUtil.isAncestor(this, newReferenceHoler))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReferenceHoler != null)
                msgs = ((InternalEObject)newReferenceHoler).eInverseAdd(this, SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS, TmpReferenceHolder.class, msgs);
            msgs = basicSetReferenceHoler(newReferenceHoler, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER, newReferenceHoler, newReferenceHoler));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReferenceHoler((TmpReferenceHolder)otherEnd, msgs);
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
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                return basicSetReferenceHoler(null, msgs);
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
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                return eInternalContainer().eInverseRemove(this, SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS, TmpReferenceHolder.class, msgs);
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
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE:
                return getToTaskType();
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO:
                if (resolve) return getTo();
                return basicGetTo();
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                return getReferenceHoler();
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
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE:
                setToTaskType((String)newValue);
                return;
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO:
                setTo((DomainObject)newValue);
                return;
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                setReferenceHoler((TmpReferenceHolder)newValue);
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
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE:
                setToTaskType(TO_TASK_TYPE_EDEFAULT);
                return;
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO:
                setTo((DomainObject)null);
                return;
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                setReferenceHoler((TmpReferenceHolder)null);
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
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO_TASK_TYPE:
                return TO_TASK_TYPE_EDEFAULT == null ? toTaskType != null : !TO_TASK_TYPE_EDEFAULT.equals(toTaskType);
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__TO:
                return to != null;
            case SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER:
                return getReferenceHoler() != null;
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
        result.append(" (toTaskType: ");
        result.append(toTaskType);
        result.append(')');
        return result.toString();
    }

} //TmpSubTaskTransitionHolderImpl
