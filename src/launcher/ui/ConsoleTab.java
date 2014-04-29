package launcher.ui;

import java.awt.Font;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class ConsoleTab extends JScrollPane
{
  private static final Font MONOSPACED = new Font("Monospaced", 0, 12);

  private final JTextPane console = new JTextPane();


  public ConsoleTab()
  {

    console.setFont(MONOSPACED);
    console.setEditable(false);
    console.setMargin(null);

    setViewportView(console);
  }



  public void print(final String line) {
    if (!SwingUtilities.isEventDispatchThread()) {
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run() {
          print(line);
        }
      });
      return;
    }

    Document document = console.getDocument();
    JScrollBar scrollBar = getVerticalScrollBar();
    boolean shouldScroll = false;

    if (getViewport().getView() == console) {
      shouldScroll = scrollBar.getValue() + scrollBar.getSize().getHeight() + MONOSPACED.getSize() * 4 > scrollBar.getMaximum();
    }
    try
    {
      document.insertString(document.getLength(), line, null);
    } catch (BadLocationException localBadLocationException) {
    }
    if (shouldScroll)
      scrollBar.setValue(2147483647);
  }
}