<html>
<body>

<?php
if ( $_POST['button'] == "" )
{
?>

	<H2> CPU and I/O Load Test</H2>
	<?php
		echo "Server Name: " . $_SERVER['SERVER_NAME']  ;
		echo "<br/>" ;
		echo "Server IP:   " . $_SERVER['SERVER_ADDR'] ;
	?>
	<br/>
    <form action="loadtest.php" method="post">
        Start CPU and I/O Load Test (for 5 mins). 
        <br/><br/>
        <input type="submit" name="button" value="Start Test">
    </form>
<?php
}
else
{
	exec( 'stress -c 2 -i 1 -m 1 --vm-bytes 128M -t 300' ) ;
	echo '<H1>DONE!</H1>' ;
}
?>

</body>
</html>