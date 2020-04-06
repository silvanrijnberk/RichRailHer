package UI;

import Domain.Domain;
import Session.Session;
import org.antlr.v4.runtime.tree.ErrorNode;
import parser.RichRailBaseListener;
import parser.RichRailParser;

public class RichRailCli extends RichRailBaseListener {
    private Domain domain;
    private Session session;

    public RichRailCli(Session session) {
        this.session = session;
        this.domain = session.getDomain();
    }

    @Override
    public void exitNewtraincommand(RichRailParser.NewtraincommandContext ctx) {
        domain.newTrain(ctx.ID().getText());
        session.getUI().draw();
    }

    @Override
    public void exitNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {
        if (ctx.NUMBER() != null) {
            domain.newComponent(ctx.ID().getText(), ctx.WAGONTYPE().getText(), Integer.parseInt(ctx.NUMBER().getText()));
            return;
        }
        domain.newComponent(ctx.ID().getText(), ctx.WAGONTYPE().getText());
    }

    @Override
    public void exitAddcommand(RichRailParser.AddcommandContext ctx) {
        String train = ctx.ID().toArray()[1].toString();
        String component = ctx.ID().toArray()[0].toString();
        domain.addToTrain(component, train);
        session.getUI().draw();
    }

    @Override
    public void exitGetcommand(RichRailParser.GetcommandContext ctx) {
        if (ctx.type().getText().equals("train")) {
            session.notify(ctx.ID().getText() + " has " + domain.getNumSeats(true, ctx.ID().getText()) + " seats");
        }
        if (ctx.type().getText().equals("component")) {
            session.notify(ctx.ID().getText() + " has " + domain.getNumSeats(false, ctx.ID().getText()) + " seats");
        }
    }

    @Override
    public void exitDelcommand(RichRailParser.DelcommandContext ctx) {
        if (ctx.type().getText().equals("train")) {
            domain.deleteTrain(ctx.ID().getText());
            session.getUI().draw();
            return;
        }
        domain.deleteComponent(ctx.ID().getText());
        session.getUI().draw();
    }

    @Override
    public void exitRemcommand(RichRailParser.RemcommandContext ctx) {
        String train = ctx.ID().toArray()[1].toString();
        String component = ctx.ID().toArray()[0].toString();
        domain.removeFromTrain(train, component);
        session.getUI().draw();
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        session.notify("wrong input: " + node.getText());
    }
}