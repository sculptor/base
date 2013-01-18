/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptorguimetamodel;

import sculptormetamodel.NamedElement;
import org.eclipse.emf.common.util.EList;
import sculptormetamodel.Attribute;
import sculptormetamodel.Reference;
import sculptormetamodel.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Data Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptorguimetamodel.ViewDataProperty#getUserTask <em>User Task</em>}</li>
 *   <li>{@link sculptorguimetamodel.ViewDataProperty#getMessageKey <em>Message Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptorguimetamodel.SculptorguimetamodelPackage#getViewDataProperty()
 * @model
 * @generated
 */
public interface ViewDataProperty extends NamedElement {
	/**
     * Returns the value of the '<em><b>User Task</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptorguimetamodel.UserTask#getViewProperties <em>View Properties</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Task</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User Task</em>' container reference.
     * @see #setUserTask(UserTask)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getViewDataProperty_UserTask()
     * @see sculptorguimetamodel.UserTask#getViewProperties
     * @model opposite="viewProperties" transient="false"
     * @generated
     */
    UserTask getUserTask();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.ViewDataProperty#getUserTask <em>User Task</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Task</em>' container reference.
     * @see #getUserTask()
     * @generated
     */
    void setUserTask(UserTask value);

    /**
     * Returns the value of the '<em><b>Message Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Message Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Message Key</em>' attribute.
     * @see #setMessageKey(String)
     * @see sculptorguimetamodel.SculptorguimetamodelPackage#getViewDataProperty_MessageKey()
     * @model
     * @generated
     */
    String getMessageKey();

    /**
     * Sets the value of the '{@link sculptorguimetamodel.ViewDataProperty#getMessageKey <em>Message Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Message Key</em>' attribute.
     * @see #getMessageKey()
     * @generated
     */
    void setMessageKey(String value);

} // ViewDataProperty
