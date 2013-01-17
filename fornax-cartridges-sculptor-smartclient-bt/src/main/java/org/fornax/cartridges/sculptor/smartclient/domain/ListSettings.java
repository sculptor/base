package org.fornax.cartridges.sculptor.smartclient.domain;

import org.fornax.cartridges.sculptor.framework.annotation.Name;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * Entity representing ListSettings.
 * This class is responsible for the domain object related
 * business logic for ListSettings. Properties and associations are
 * implemented in the generated base class {@link org.fornax.cartridges.sculptor.smartclient.domain.ListSettingsBase}.
 */
@Entity
@NamedQueries( {
	@NamedQuery(name="Users.findByUsername", query="from Users as user where user.username = :username"),
	@NamedQuery(name="PropertyService.findAllNotDefaultProperty", query="from Property")
})
@Table(name = "LISTSETTINGS", uniqueConstraints = @UniqueConstraint(columnNames =  {
    "LISTID", "USERNAME"}
)
)
public class ListSettings extends ListSettingsBase {
    private static final long serialVersionUID = 1L;

    protected ListSettings() {
    }

    public ListSettings(@Name("listID")
    String listID, @Name("userName")
    String userName) {
        super(listID, userName);
    }
}
