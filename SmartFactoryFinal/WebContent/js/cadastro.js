  $(document).ready(function() {
    $('.nav-toggle').click(function(){
      //get collapse content selector
      var collapse_content_selector = $(this).attr('href');

      //make the collapse content to be shown or hide
      var toggle_switch = $(this);
      $(collapse_content_selector).toggle(function(){
        if($(this).css('display')=='none'){
          toggle_switch.html('+');//change the button label to be 'Show'
        }else{
          toggle_switch.html('Hide');//change the button label to be 'Hide'
        }
      });
    });

  });
  
  $(document).ready(function() {
    $('.nav-toggle').click(function(){
      //get collapse content selector
      var collapse_content_selector = $(this).attr('href');

      //make the collapse content to be shown or hide
      var toggle_switch = $(this);
      $(collapse_content_selector).toggle(function(){
        if($(this).css('display')=='none'){
          toggle_switch.html('+');//change the button label to be 'Show'
        }else{
          toggle_switch.html('Hide');//change the button label to be 'Hide'
        }
      });
    });

  });