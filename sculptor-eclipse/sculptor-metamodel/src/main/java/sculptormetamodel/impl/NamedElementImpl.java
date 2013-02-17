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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import sculptormetamodel.NamedElement;
import sculptormetamodel.SculptormetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptormetamodel.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link sculptormetamodel.impl.NamedElementImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link sculptormetamodel.impl.NamedElementImpl#getHint <em>Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedElementImpl extends EObjectImpl implements NamedElement {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDoc() <em>Doc</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDoc()
     * @generated
     * @ordered
     */
    protected static final String DOC_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDoc() <em>Doc</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDoc()
     * @generated
     * @ordered
     */
    protected String doc = DOC_EDEFAULT;

    /**
     * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHint()
     * @generated
     * @ordered
     */
    protected static final String HINT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHint()
     * @generated
     * @ordered
     */
    protected String hint = HINT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NamedElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptormetamodelPackage.Literals.NAMED_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.NAMED_ELEMENT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDoc() {
        return doc;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDoc(String newDoc) {
        String oldDoc = doc;
        doc = newDoc;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.NAMED_ELEMENT__DOC, oldDoc, doc));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHint() {
        return hint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHint(String newHint) {
        String oldHint = hint;
        hint = newHint;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptormetamodelPackage.NAMED_ELEMENT__HINT, oldHint, hint));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SculptormetamodelPackage.NAMED_ELEMENT__NAME:
                return getName();
            case SculptormetamodelPackage.NAMED_ELEMENT__DOC:
                return getDoc();
            case SculptormetamodelPackage.NAMED_ELEMENT__HINT:
                return getHint();
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
            case SculptormetamodelPackage.NAMED_ELEMENT__NAME:
                setName((String)newValue);
                return;
            case SculptormetamodelPackage.NAMED_ELEMENT__DOC:
                setDoc((String)newValue);
                return;
            case SculptormetamodelPackage.NAMED_ELEMENT__HINT:
                setHint((String)newValue);
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
            case SculptormetamodelPackage.NAMED_ELEMENT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SculptormetamodelPackage.NAMED_ELEMENT__DOC:
                setDoc(DOC_EDEFAULT);
                return;
            case SculptormetamodelPackage.NAMED_ELEMENT__HINT:
                setHint(HINT_EDEFAULT);
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
            case SculptormetamodelPackage.NAMED_ELEMENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SculptormetamodelPackage.NAMED_ELEMENT__DOC:
                return DOC_EDEFAULT == null ? doc != null : !DOC_EDEFAULT.equals(doc);
            case SculptormetamodelPackage.NAMED_ELEMENT__HINT:
                return HINT_EDEFAULT == null ? hint != null : !HINT_EDEFAULT.equals(hint);
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
        result.append(" (name: ");
        result.append(name);
        result.append(", doc: ");
        result.append(doc);
        result.append(", hint: ");
        result.append(hint);
        result.append(')');
        return result.toString();
    }

} //NamedElementImpl