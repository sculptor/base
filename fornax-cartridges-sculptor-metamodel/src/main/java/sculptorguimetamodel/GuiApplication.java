/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import org.eclipse.emf.common.util.EList;

import sculptormetamodel.Application;
import sculptormetamodel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gui Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.GuiApplication#getGuiForApplication <em>Gui For Application</em>}</li>
 *   <li>{@link sculptorguimetamodel.GuiApplication#getModules <em>Modules</em>}</li>
 *   <li>{@link sculptorguimetamodel.GuiApplication#getBasePackage <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiApplication()
 * @model
 * @generated
 */
public interface GuiApplication extends NamedElement {
	/**
     * Returns the value of the '<em><b>Gui For Application</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gui For Application</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Gui For Application</em>' reference.
     * @see #setGuiForApplication(Application)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiApplication_GuiForApplication()
     * @model required="true"
     * @generated
     */
	Application getGuiForApplication();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.GuiApplication#getGuiForApplication <em>Gui For Application</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gui For Application</em>' reference.
     * @see #getGuiForApplication()
     * @generated
     */
	void setGuiForApplication(Application value);

	/**
     * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
     * The list contents are of type {@link sculptorguimetamodel.GuiModule}.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.GuiModule#getApplication <em>Application</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Modules</em>' containment reference list.
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiApplication_Modules()
     * @see sculptorguimetamodel.GuiModule#getApplication
     * @model type="sculptorguimetamodel.GuiModule" opposite="application" containment="true" required="true"
     * @generated
     */
	EList getModules();

	/**
     * Returns the value of the '<em><b>Base Package</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Package</em>' attribute.
     * @see #setBasePackage(String)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getGuiApplication_BasePackage()
     * @model
     * @generated
     */
	String getBasePackage();

	/**
     * Sets the value of the '{@link sculptorguimetamodel.GuiApplication#getBasePackage <em>Base Package</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Package</em>' attribute.
     * @see #getBasePackage()
     * @generated
     */
	void setBasePackage(String value);

} // GuiApplication
