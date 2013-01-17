/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sculptormetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sculptormetamodel.Reference#isMany <em>Many</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getTo <em>To</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getCascade <em>Cascade</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getOrderBy <em>Order By</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getFrom <em>From</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isRequired <em>Required</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getFetch <em>Fetch</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isCache <em>Cache</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isNaturalKey <em>Natural Key</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isInverse <em>Inverse</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isNullable <em>Nullable</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getDatabaseColumn <em>Database Column</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getValidate <em>Validate</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#isTransient <em>Transient</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getDatabaseJoinTable <em>Database Join Table</em>}</li>
 *   <li>{@link sculptormetamodel.Reference#getDatabaseJoinColumn <em>Database Join Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see sculptormetamodel.SculptormetamodelPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends NamedElement {
    /**
     * Returns the value of the '<em><b>Many</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Many</em>' attribute.
     * @see #setMany(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Many()
     * @model
     * @generated
     */
	boolean isMany();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isMany <em>Many</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Many</em>' attribute.
     * @see #isMany()
     * @generated
     */
	void setMany(boolean value);

    /**
     * Returns the value of the '<em><b>Collection Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Collection Type</em>' attribute.
     * @see #setCollectionType(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_CollectionType()
     * @model
     * @generated
     */
	String getCollectionType();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getCollectionType <em>Collection Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Collection Type</em>' attribute.
     * @see #getCollectionType()
     * @generated
     */
	void setCollectionType(String value);

    /**
     * Returns the value of the '<em><b>Opposite</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Opposite</em>' reference.
     * @see #setOpposite(Reference)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Opposite()
     * @model
     * @generated
     */
	Reference getOpposite();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getOpposite <em>Opposite</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Opposite</em>' reference.
     * @see #getOpposite()
     * @generated
     */
	void setOpposite(Reference value);

    /**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(DomainObject)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_To()
     * @model required="true"
     * @generated
     */
	DomainObject getTo();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
	void setTo(DomainObject value);

    /**
     * Returns the value of the '<em><b>Cascade</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cascade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cascade</em>' attribute.
     * @see #setCascade(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Cascade()
     * @model
     * @generated
     */
	String getCascade();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getCascade <em>Cascade</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cascade</em>' attribute.
     * @see #getCascade()
     * @generated
     */
	void setCascade(String value);

    /**
     * Returns the value of the '<em><b>Order By</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Order By</em>' attribute.
     * @see #setOrderBy(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_OrderBy()
     * @model
     * @generated
     */
	String getOrderBy();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getOrderBy <em>Order By</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Order By</em>' attribute.
     * @see #getOrderBy()
     * @generated
     */
	void setOrderBy(String value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see #setVisibility(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Visibility()
     * @model
     * @generated
     */
	String getVisibility();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
	void setVisibility(String value);

    /**
     * Returns the value of the '<em><b>Changeable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Changeable</em>' attribute.
     * @see #setChangeable(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Changeable()
     * @model default="true"
     * @generated
     */
	boolean isChangeable();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isChangeable <em>Changeable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Changeable</em>' attribute.
     * @see #isChangeable()
     * @generated
     */
	void setChangeable(boolean value);

    /**
     * Returns the value of the '<em><b>From</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link sculptormetamodel.DomainObject#getReferences <em>References</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' container reference.
     * @see #setFrom(DomainObject)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_From()
     * @see sculptormetamodel.DomainObject#getReferences
     * @model opposite="references" transient="false"
     * @generated
     */
	DomainObject getFrom();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getFrom <em>From</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' container reference.
     * @see #getFrom()
     * @generated
     */
	void setFrom(DomainObject value);

    /**
     * Returns the value of the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Required</em>' attribute.
     * @see #setRequired(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Required()
     * @model
     * @generated
     */
	boolean isRequired();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isRequired <em>Required</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required</em>' attribute.
     * @see #isRequired()
     * @generated
     */
	void setRequired(boolean value);

    /**
     * Returns the value of the '<em><b>Fetch</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fetch</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fetch</em>' attribute.
     * @see #setFetch(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Fetch()
     * @model
     * @generated
     */
    String getFetch();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getFetch <em>Fetch</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fetch</em>' attribute.
     * @see #getFetch()
     * @generated
     */
    void setFetch(String value);

    /**
     * Returns the value of the '<em><b>Cache</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cache</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cache</em>' attribute.
     * @see #setCache(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Cache()
     * @model
     * @generated
     */
    boolean isCache();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isCache <em>Cache</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cache</em>' attribute.
     * @see #isCache()
     * @generated
     */
    void setCache(boolean value);

    /**
     * Returns the value of the '<em><b>Natural Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Natural Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Natural Key</em>' attribute.
     * @see #setNaturalKey(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_NaturalKey()
     * @model
     * @generated
     */
    boolean isNaturalKey();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isNaturalKey <em>Natural Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Natural Key</em>' attribute.
     * @see #isNaturalKey()
     * @generated
     */
    void setNaturalKey(boolean value);

    /**
     * Returns the value of the '<em><b>Inverse</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inverse</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inverse</em>' attribute.
     * @see #setInverse(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Inverse()
     * @model
     * @generated
     */
    boolean isInverse();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isInverse <em>Inverse</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inverse</em>' attribute.
     * @see #isInverse()
     * @generated
     */
    void setInverse(boolean value);

    /**
     * Returns the value of the '<em><b>Nullable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nullable</em>' attribute.
     * @see #setNullable(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Nullable()
     * @model
     * @generated
     */
    boolean isNullable();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isNullable <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nullable</em>' attribute.
     * @see #isNullable()
     * @generated
     */
    void setNullable(boolean value);

    /**
     * Returns the value of the '<em><b>Database Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Column</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database Column</em>' attribute.
     * @see #setDatabaseColumn(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_DatabaseColumn()
     * @model
     * @generated
     */
    String getDatabaseColumn();

    /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getDatabaseColumn <em>Database Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Column</em>' attribute.
     * @see #getDatabaseColumn()
     * @generated
     */
    void setDatabaseColumn(String value);

				/**
     * Returns the value of the '<em><b>Validate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Validate</em>' attribute.
     * @see #setValidate(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Validate()
     * @model
     * @generated
     */
	String getValidate();

				/**
     * Sets the value of the '{@link sculptormetamodel.Reference#getValidate <em>Validate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Validate</em>' attribute.
     * @see #getValidate()
     * @generated
     */
	void setValidate(String value);

				/**
     * Returns the value of the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transient</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transient</em>' attribute.
     * @see #setTransient(boolean)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_Transient()
     * @model
     * @generated
     */
    boolean isTransient();

                /**
     * Sets the value of the '{@link sculptormetamodel.Reference#isTransient <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transient</em>' attribute.
     * @see #isTransient()
     * @generated
     */
    void setTransient(boolean value);

                /**
     * Returns the value of the '<em><b>Database Join Table</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Join Table</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database Join Table</em>' attribute.
     * @see #setDatabaseJoinTable(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_DatabaseJoinTable()
     * @model
     * @generated
     */
    String getDatabaseJoinTable();

                /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getDatabaseJoinTable <em>Database Join Table</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Join Table</em>' attribute.
     * @see #getDatabaseJoinTable()
     * @generated
     */
    void setDatabaseJoinTable(String value);

                /**
     * Returns the value of the '<em><b>Database Join Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Join Column</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database Join Column</em>' attribute.
     * @see #setDatabaseJoinColumn(String)
     * @see sculptormetamodel.SculptormetamodelPackage#getReference_DatabaseJoinColumn()
     * @model
     * @generated
     */
    String getDatabaseJoinColumn();

                /**
     * Sets the value of the '{@link sculptormetamodel.Reference#getDatabaseJoinColumn <em>Database Join Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Join Column</em>' attribute.
     * @see #getDatabaseJoinColumn()
     * @generated
     */
    void setDatabaseJoinColumn(String value);

} // Reference