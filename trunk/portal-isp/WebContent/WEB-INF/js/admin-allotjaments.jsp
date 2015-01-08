<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	function onLoad() {		
		$("a.link-eliminar").on("click", function(e) {
			var link = this;
			e.preventDefault();			

			$("div#confirmar").dialog({
				dialogClass : 'alert',
				buttons: {
			        'Si': function() {
			        	window.location = link.href;
			            $(this).dialog('close');
			        },
			        'No': function() {
			            $(this).dialog('close');
			        }
			    },
			    create:function () {
			        $(".ui-button").addClass("button");
			        $(".ui-button-text:contains(Close)").text("X");			      
			     
			    }
			});
		});

	}

	$(document).ready(onLoad);
</script>