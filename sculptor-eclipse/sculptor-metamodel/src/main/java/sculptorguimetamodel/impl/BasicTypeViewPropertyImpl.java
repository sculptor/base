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

import sculptorguimetamodel.BasicTypeViewProperty;
import sculptorguimetamodel.SculptorguimetamodelPackage;

import sculptormetamodel.Attribute;
import sculptormetamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Type View Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.BasicTypeViewPropertyImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.BasicTypeViewPropertyImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicTypeViewPropertyImpl extends ViewDataPropertyImpl implements BasicTypeViewProperty {
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
     * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected Attribute attribute;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BasicTypeViewPropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.BASIC_TYPE_VIEW_PROPERTY;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__REFERENCE, oldReference, reference));
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
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__REFERENCE, oldReference, reference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Attribute getAttribute() {
        if (attribute != null && attribute.eIsProxy()) {
            InternalEObject oldAttribute = (InternalEObject)attribute;
            attribute = (Attribute)eResolveProxy(oldAttribute);
            if (attribute != oldAttribute) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE, oldAttribute, attribute));
            }
        }
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Attribute basicGetAttribute() {
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttribute(Attribute newAttribute) {
        Attribute oldAttribute = attribute;
        attribute = newAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE, oldAttribute, attribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__REFERENCE:
                if (resolve) return getReference();
                return basicGetReference();
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE:
                if (resolve) return getAttribute();
                return basicGetAttribute();
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
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__REFERENCE:
                setReference((Reference)newValue);
                return;
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE:
                setAttribute((Attribute)newValue);
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
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__REFERENCE:
                setReference((Reference)null);
                return;
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE:
                setAttribute((Attribute)null);
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
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__REFERENCE:
                return reference != null;
            case SculptorguimetamodelPackage.BASIC_TYPE_VIEW_PROPERTY__ATTRIBUTE:
                return attribute != null;
        }
        return super.eIsSet(featureID);
    }

} //BasicTypeViewPropertyImpl
