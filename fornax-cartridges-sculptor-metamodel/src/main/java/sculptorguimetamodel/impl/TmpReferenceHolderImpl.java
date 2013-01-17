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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.TmpReferenceHolder;
import sculptorguimetamodel.TmpSubTaskTransitionHolder;

import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmp Reference Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.TmpReferenceHolderImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.TmpReferenceHolderImpl#getSubTaskTransitionHolders <em>Sub Task Transition Holders</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TmpReferenceHolderImpl extends EObjectImpl implements TmpReferenceHolder {
	/**
     * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getReference()
     * @generated
     * @ordered
     */
	protected Reference reference;

	/**
     * The cached value of the '{@link #getSubTaskTransitionHolders() <em>Sub Task Transition Holders</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSubTaskTransitionHolders()
     * @generated
     * @ordered
     */
	protected EList subTaskTransitionHolders;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TmpReferenceHolderImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.TMP_REFERENCE_HOLDER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference getReference() {
        if (reference != null && reference.eIsProxy()) {
            InternalEObject oldReference = (InternalEObject)reference;
            reference = (Reference)eResolveProxy(oldReference);
            if (reference != oldReference) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__REFERENCE, oldReference, reference));
            }
        }
        return reference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Reference basicGetReference() {
        return reference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setReference(Reference newReference) {
        Reference oldReference = reference;
        reference = newReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__REFERENCE, oldReference, reference));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getSubTaskTransitionHolders() {
        if (subTaskTransitionHolders == null) {
            subTaskTransitionHolders = new EObjectContainmentWithInverseEList(TmpSubTaskTransitionHolder.class, this, SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS, SculptorguimetamodelPackage.TMP_SUB_TASK_TRANSITION_HOLDER__REFERENCE_HOLER);
        }
        return subTaskTransitionHolders;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS:
                return ((InternalEList)getSubTaskTransitionHolders()).basicAdd(otherEnd, msgs);
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
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS:
                return ((InternalEList)getSubTaskTransitionHolders()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__REFERENCE:
                if (resolve) return getReference();
                return basicGetReference();
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS:
                return getSubTaskTransitionHolders();
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
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__REFERENCE:
                setReference((Reference)newValue);
                return;
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS:
                getSubTaskTransitionHolders().clear();
                getSubTaskTransitionHolders().addAll((Collection)newValue);
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
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__REFERENCE:
                setReference((Reference)null);
                return;
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS:
                getSubTaskTransitionHolders().clear();
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
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__REFERENCE:
                return reference != null;
            case SculptorguimetamodelPackage.TMP_REFERENCE_HOLDER__SUB_TASK_TRANSITION_HOLDERS:
                return subTaskTransitionHolders != null && !subTaskTransitionHolders.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TmpReferenceHolderImpl
