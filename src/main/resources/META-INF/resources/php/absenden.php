<?php
$anrede     = $_REQUEST['anrede'];
$mail       = $_REQUEST['mail'];
$name       = $_REQUEST['name'];
$nachname   = $_REQUEST['nachname'];
$nachricht  = $_REQUEST['nachricht'];

if(!empty($anrede) && !empty($mail) && !empty($name ) && !empty($nachname) && !empty($nachricht)) {
    
    $empfaenger = "konstanzermvz@gmx.de";
    $absender = $mail;

    $betreffwebmaster = "Kontaktanfrage ($name $nachname)";
    $koerperwebmaster = "$name $nachname hat ueber die Webseite http://konstanzermvz.bplaced.net/ eine Kontaktanfrage gestellt. \n" . "\nKontaktdaten: \n Name: $anrede $name $nachname \nE-Mail: $mail \n\nNachricht:\n" . $nachricht;

    $betreffkunde = "Ihre Kontaktanfrage";
    $koerperkunde = "Sie ($name $nachname) haben ueber die Webseite http://konstanzermvz.bplaced.net/ eine Kontaktanfrage gestellt. \n" . "\nIhre Kontaktdaten: \nName: $anrede $name $nachname \nE-Mail: $mail \n\nIhre Nachricht:\n" . $nachricht;

    mail("$empfaenger",
         "$betreffwebmaster",
         "$koerperwebmaster\n",
         "FROM: $absender\n");
    mail("$mail",
         "$betreffkunde",
         "$koerperkunde\n",
         "FROM: $absender\n");
    
    // Weiterleitung auf die Danke-Seite
    header("Location: ../kontakt_danke.html#collapsibleNavbar");
    
} else {
    // Weiterleitung auf die Fehler-Seite
    header("Location: ../kontakt_fehler.html#collapsibleNavbar");
}
?>