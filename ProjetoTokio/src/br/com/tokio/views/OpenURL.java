package br.com.tokio.views;

import java.lang.reflect.Method;

import javax.swing.JOptionPane;

public class OpenURL {
	 
	public static void open(String url) {
		String errMsg = "Erro ao tentar abrir o browser";
        String osName = System.getProperty("os.name");
        String browser = null;
        try {
            if (osName.startsWith("Mac OS")) {
                Class fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL",
                        new Class[]{String.class});
                openURL.invoke(null, new Object[]{url});
            } else if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else { //assume Unix or Linux   
                String[] browsers = {
                    "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"
                };
                for (int count = 0; count < browsers.length && browser == null; count++) {
                    if (Runtime.getRuntime().exec(
                            new String[]{"which", browsers[count]}).waitFor() == 0) {
                        browser = browsers[count];
                    }
                }
                JOptionPane.showMessageDialog(null,browser);
                if (browser == null) {
                    JOptionPane.showMessageDialog(null,"Navegador não encontrado!");
                } else {
                    Runtime.getRuntime().exec(new String[]{browser,url});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, errMsg + ":\n" + e.getLocalizedMessage());
        }
    }
}
