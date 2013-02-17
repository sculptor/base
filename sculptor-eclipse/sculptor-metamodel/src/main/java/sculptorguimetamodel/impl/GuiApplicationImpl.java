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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.SculptorguimetamodelPackage;

import sculptormetamodel.Application;

import sculptormetamodel.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gui Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sculptorguimetamodel.impl.GuiApplicationImpl#getGuiForApplication <em>Gui For Application</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.GuiApplicationImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link sculptorguimetamodel.impl.GuiApplicationImpl#getBasePackage <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuiApplicationImpl extends NamedElementImpl implements GuiApplication {
	/**
     * The cached value of the '{@link #getGuiForApplication() <em>Gui For Application</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getGuiForApplication()
     * @generated
     * @ordered
     */
	protected Application guiForApplication;

	/**
     * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getModules()
     * @generated
     * @ordered
     */
	protected EList modules;

	/**
     * The default value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBasePackage()
     * @generated
     * @ordered
     */
	protected static final String BASE_PACKAGE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getBasePackage() <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBasePackage()
     * @generated
     * @ordered
     */
	protected String basePackage = BASE_PACKAGE_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected GuiApplicationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SculptorguimetamodelPackage.Literals.GUI_APPLICATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Application getGuiForApplication() {
        if (guiForApplication != null && guiForApplication.eIsProxy()) {
            InternalEObject oldGuiForApplication = (InternalEObject)guiForApplication;
            guiForApplication = (Application)eResolveProxy(oldGuiForApplication);
            if (guiForApplication != oldGuiForApplication) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SculptorguimetamodelPackage.GUI_APPLICATION__GUI_FOR_APPLICATION, oldGuiForApplication, guiForApplication));
            }
        }
        return guiForApplication;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Application basicGetGuiForApplication() {
        return guiForApplication;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setGuiForApplication(Application newGuiForApplication) {
        Application oldGuiForApplication = guiForApplication;
        guiForApplication = newGuiForApplication;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.GUI_APPLICATION__GUI_FOR_APPLICATION, oldGuiForApplication, guiForApplication));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getModules() {
        if (modules == null) {
            modules = new EObjectContainmentWithInverseEList(GuiModule.class, this, SculptorguimetamodelPackage.GUI_APPLICATION__MODULES, SculptorguimetamodelPackage.GUI_MODULE__APPLICATION);
        }
        return modules;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getBasePackage() {
        return basePackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBasePackage(String newBasePackage) {
        String oldBasePackage = basePackage;
        basePackage = newBasePackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SculptorguimetamodelPackage.GUI_APPLICATION__BASE_PACKAGE, oldBasePackage, basePackage));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SculptorguimetamodelPackage.GUI_APPLICATION__MODULES:
                return ((InternalEList)getModules()).basicAdd(otherEnd, msgs);
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
            case SculptorguimetamodelPackage.GUI_APPLICATION__MODULES:
                return ((InternalEList)getModules()).basicRemove(otherEnd, msgs);
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
            case SculptorguimetamodelPackage.GUI_APPLICATION__GUI_FOR_APPLICATION:
                if (resolve) return getGuiForApplication();
                return basicGetGuiForApplication();
            case SculptorguimetamodelPackage.GUI_APPLICATION__MODULES:
                return getModules();
            case SculptorguimetamodelPackage.GUI_APPLICATION__BASE_PACKAGE:
                return getBasePackage();
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
            case SculptorguimetamodelPackage.GUI_APPLICATION__GUI_FOR_APPLICATION:
                setGuiForApplication((Application)newValue);
                return;
            case SculptorguimetamodelPackage.GUI_APPLICATION__MODULES:
                getModules().clear();
                getModules().addAll((Collection)newValue);
                return;
            case SculptorguimetamodelPackage.GUI_APPLICATION__BASE_PACKAGE:
                setBasePackage((String)newValue);
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
            case SculptorguimetamodelPackage.GUI_APPLICATION__GUI_FOR_APPLICATION:
                setGuiForApplication((Application)null);
                return;
            case SculptorguimetamodelPackage.GUI_APPLICATION__MODULES:
                getModules().clear();
                return;
            case SculptorguimetamodelPackage.GUI_APPLICATION__BASE_PACKAGE:
                setBasePackage(BASE_PACKAGE_EDEFAULT);
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
            case SculptorguimetamodelPackage.GUI_APPLICATION__GUI_FOR_APPLICATION:
                return guiForApplication != null;
            case SculptorguimetamodelPackage.GUI_APPLICATION__MODULES:
                return modules != null && !modules.isEmpty();
            case SculptorguimetamodelPackage.GUI_APPLICATION__BASE_PACKAGE:
                return BASE_PACKAGE_EDEFAULT == null ? basePackage != null : !BASE_PACKAGE_EDEFAULT.equals(basePackage);
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
        result.append(" (basePackage: ");
        result.append(basePackage);
        result.append(')');
        return result.toString();
    }

} //GuiApplicationImpl
