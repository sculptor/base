package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.util.Set;

import org.fornax.cartridges.sculptor.framework.annotation.GuiHints;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.DetailBehavior;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.VisibleOn;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.smartclient.domain.ClientCommand;
import org.fornax.cartridges.sculptor.smartclient.framework.MessageBroadcaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of ClientCommandService.
 */
@Service("clientCommandService")
public class ClientCommandServiceImpl extends ClientCommandServiceImplBase {

	@Autowired
	MessageBroadcaster broadcaster;

	public ClientCommandServiceImpl() {
	}

	@GuiHints(detailBehavior=DetailBehavior.ON_NEW)
	public void sendCommand(@Name("ctx") ServiceContext ctx, @Name("cmd") ClientCommand cmd) {
		broadcaster.broadcastMessage(cmd, cmd.getSendTo().split("[,;: ]"));
	}

	@GuiHints(visibleOn=VisibleOn.HIDDEN)
	public void sendCommands(@Name("ctx") ServiceContext ctx, @Name("cmd1") ClientCommand cmd1
			, @Name("cmd2") ClientCommand cmd2, @Name("cmd3") ClientCommand cmd3
			, @Name("cmd4") ClientCommand cmd4, @Name("cmd5") ClientCommand cmd5) {
		ClientCommand[] commands = { cmd1, cmd2, cmd3, cmd4, cmd5 };
		for (int i = 0; i < commands.length; i++) {
			if (commands[i] != null) {
				sendCommand(ctx, commands[i]);
			}
		}
	}

	@GuiHints(visibleOn=VisibleOn.ON_LIST)
	public Set<ClientCommand> getCommands(@Name("ctx") ServiceContext ctx) {
		return null;
	}

}
