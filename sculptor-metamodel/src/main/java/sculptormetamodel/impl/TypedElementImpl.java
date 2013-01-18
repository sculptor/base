/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sculptormetamodel.SculptormetamodelPackage;
import sculptormetamodel.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.TypedElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link sculptormetamodel.impl.TypedElementImpl#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link sculptormetamodel.impl.TypedElementImpl#getMapKeyType <em>Map Key Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypedElementImpl extends NamedElementImpl implements TypedElement {
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected static final String TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected String type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionType()
     * @generated
     * @ordered
     */
	protected static final String COLLECTION_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollectionType()
     * @generated
     * @ordered
     */
	protected String collectionType = COLLECTION_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getMapKeyType() <em>Map Key Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMapKeyType()
     * @generated
     * @ordered
     */
	protected static final String MAP_KEY_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMapKeyType() <em>Map Key Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMapKeyType()
     * @generated
     * @ordered
     */
	protected String mapKeyType = MAP_KEY_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TypedElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.TYPED_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.TYPED_ELEMENT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getCollectionType() {
        return collectionType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCollectionType(String newCollectionType) {
        String oldCollectionType = collectionType;
        collectionType = newCollectionType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.TYPED_ELEMENT__COLLECTION_TYPE, oldCollectionType, collectionType));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getMapKeyType() {
        return mapKeyType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMapKeyType(String newMapKeyType) {
        String oldMapKeyType = mapKeyType;
        mapKeyType = newMapKeyType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.TYPED_ELEMENT__MAP_KEY_TYPE, oldMapKeyType, mapKeyType));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.TYPED_ELEMENT__TYPE:
                return getType();
            case SculptormetamodelPackage.TYPED_ELEMENT__COLLECTION_TYPE:
                return getCollectionType();
            case SculptormetamodelPackage.TYPED_ELEMENT__MAP_KEY_TYPE:
                return getMapKeyType();
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
            case SculptormetamodelPackage.TYPED_ELEMENT__TYPE:
                setType((String)newValue);
                return;
            case SculptormetamodelPackage.TYPED_ELEMENT__COLLECTION_TYPE:
                setCollectionType((String)newValue);
                return;
            case SculptormetamodelPackage.TYPED_ELEMENT__MAP_KEY_TYPE:
                setMapKeyType((String)newValue);
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
            case SculptormetamodelPackage.TYPED_ELEMENT__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case SculptormetamodelPackage.TYPED_ELEMENT__COLLECTION_TYPE:
                setCollectionType(COLLECTION_TYPE_EDEFAULT);
                return;
            case SculptormetamodelPackage.TYPED_ELEMENT__MAP_KEY_TYPE:
                setMapKeyType(MAP_KEY_TYPE_EDEFAULT);
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
            case SculptormetamodelPackage.TYPED_ELEMENT__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case SculptormetamodelPackage.TYPED_ELEMENT__COLLECTION_TYPE:
                return COLLECTION_TYPE_EDEFAULT == null ? collectionType != null : !COLLECTION_TYPE_EDEFAULT.equals(collectionType);
            case SculptormetamodelPackage.TYPED_ELEMENT__MAP_KEY_TYPE:
                return MAP_KEY_TYPE_EDEFAULT == null ? mapKeyType != null : !MAP_KEY_TYPE_EDEFAULT.equals(mapKeyType);
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
        result.append(" (type: ");
        result.append(type);
        result.append(", collectionType: ");
        result.append(collectionType);
        result.append(", mapKeyType: ");
        result.append(mapKeyType);
        result.append(')');
        return result.toString();
    }

} //TypedElementImpl