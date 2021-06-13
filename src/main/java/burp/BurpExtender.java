package burp;

import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BurpExtender implements IBurpExtender, IContextMenuFactory, ITab
{

    private IContextMenuInvocation menuInvocation;
    private IBurpExtenderCallbacks burpCallbacks;
    private PrintWriter stdout;

    private JPanel jPanel;
    private JButton jButton;

    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
    {
        this.burpCallbacks = callbacks;
        this.burpCallbacks.setExtensionName("Extension Template");
        this.burpCallbacks.registerContextMenuFactory(this);

        stdout = new PrintWriter(this.burpCallbacks.getStdout(), true);
        stdout.println("INFO : Hello");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create a tab
                jPanel = new JPanel();
                jButton = new JButton("Click me");
                jPanel.add(jButton);
                callbacks.customizeUiComponent(jPanel);
                callbacks.addSuiteTab(BurpExtender.this);
            }
        });
    }
    
    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation)
    {
        List<JMenuItem> menuList = new ArrayList<>();
        menuInvocation = invocation;
        
        if(menuInvocation.getInvocationContext() == IContextMenuInvocation.CONTEXT_PROXY_HISTORY) {
            JMenuItem GeneratePocButton = new JMenuItem("Template Extension");
            GeneratePocButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if(arg0.getActionCommand().equals("Template Extension")) {
                        stdout.println("INFO : Clicked!");
                   }
               }
            });
            menuList.add(GeneratePocButton);
        }
        
        return menuList;
    }

    @Override
    public String getTabCaption() {
        // Return the title of the custom tab page
        return "Extension Template PoC";
    }
 
    @Override
    public Component getUiComponent() {
        // Return the component object of the panel in the custom tab
        return jPanel;
    }
}
