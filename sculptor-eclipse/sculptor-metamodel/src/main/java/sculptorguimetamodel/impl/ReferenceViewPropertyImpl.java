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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import sculptorguimetamodel.ReferenceViewProperty;
import sculptorguimetamodel.SculptorguimetamodelPackage;
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.ViewDataProperty;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference View Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl#getRelatedTransitions <em>Related Transitions</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl#isBase <em>Base</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.ReferenceViewPropertyImpl#getPreviewProperties <em>Preview Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceViewPropertyImpl extends ViewDataPropertyImpl implements ReferenceViewProperty {
    /**
     * The cached value of the '{@link #getRelatedTransitions() <em>Related Transitions</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRelatedTransitions()
     * @generated
     * @ordered
     */
    protected EList relatedTransitions;

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
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected DomainObject target;

    /**
     * The default value of the '{@link #isBase() <em>Base</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isBase()
     * @generated
     * @ordered
     */
	protected static final boolean BASE_EDEFAULT = false;

				/**
     * The cached value of the '{@link #isBase() <em>Base</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isBase()
     * @generated
     * @ordered
     */
	protected boolean base = BASE_EDEFAULT;

				/**
     * The cached value of the '{@link #getPreviewProperties() <em>Preview Properties</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPreviewProperties()
     * @generated
     * @ordered
     */
    protected EList previewProperties;

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReferenceViewPropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.REFERENCE_VIEW_PROPERTY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getRelatedTransitions() {
        if (relatedTransitions == null) {
            relatedTransitions = new EObjectResolvingEList(SubTaskTransition.class, this, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS);
        }
        return relatedTransitions;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__REFERENCE, oldReference, reference));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__REFERENCE, oldReference, reference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (DomainObject)eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__TARGET, oldTarget, target));
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DomainObject basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTarget(DomainObject newTarget) {
        DomainObject oldTarget = target;
        target = newTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__TARGET, oldTarget, target));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isBase() {
        return base;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBase(boolean newBase) {
        boolean oldBase = base;
        base = newBase;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__BASE, oldBase, base));
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getPreviewProperties() {
        if (previewProperties == null) {
            previewProperties = new EObjectResolvingEList(ViewDataProperty.class, this, SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES);
        }
        return previewProperties;
    }

                /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS:
                return getRelatedTransitions();
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__REFERENCE:
                if (resolve) return getReference();
                return basicGetReference();
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__BASE:
                return isBase() ? Boolean.TRUE : Boolean.FALSE;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES:
                return getPreviewProperties();
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
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS:
                getRelatedTransitions().clear();
                getRelatedTransitions().addAll((Collection)newValue);
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__REFERENCE:
                setReference((Reference)newValue);
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__TARGET:
                setTarget((DomainObject)newValue);
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__BASE:
                setBase(((Boolean)newValue).booleanValue());
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES:
                getPreviewProperties().clear();
                getPreviewProperties().addAll((Collection)newValue);
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
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS:
                getRelatedTransitions().clear();
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__REFERENCE:
                setReference((Reference)null);
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__TARGET:
                setTarget((DomainObject)null);
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__BASE:
                setBase(BASE_EDEFAULT);
                return;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES:
                getPreviewProperties().clear();
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
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__RELATED_TRANSITIONS:
                return relatedTransitions != null && !relatedTransitions.isEmpty();
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__REFERENCE:
                return reference != null;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__TARGET:
                return target != null;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__BASE:
                return base != BASE_EDEFAULT;
            case SculptorguimetamodelPackage.REFERENCE_VIEW_PROPERTY__PREVIEW_PROPERTIES:
                return previewProperties != null && !previewProperties.isEmpty();
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
        result.append(" (base: ");
        result.append(base);
        result.append(')');
        return result.toString();
    }

} //ReferenceViewPropertyImpl
