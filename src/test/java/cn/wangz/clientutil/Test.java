package cn.wangz.clientutil;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hadoop on 2019/2/18.
 */
public class Test {
    public static void main(String[] args) {
        String html = "\n" +
                "<!DOCTYPE html>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<html lang=\"en-US\">\n" +
                "\t<head>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\t\n" +
                "\t\t\t \n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t<meta name=\"Description\" content=\"In this paper, we propose an efficient quantum algorithm for spectral regression which is a dimensionality reduction framework based on the regression and \">\n" +
                "\t\t\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "\t\t\n" +
                "\t\t<!-- Disable \"click\" touch event 300ms delay for Chrome/Firefox on Android -->\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t\t\n" +
                "\t\t<title>Quantum Algorithm for Spectral Regression for Regularized Subspace Learning - IEEE Journals &amp; Magazine</title>\n" +
                "\t\t\n" +
                "\t\t<script src=\"https://s3-us-west-2.amazonaws.com/ieeeshutpages/gdpr/settings.js\"></script>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.0.3/cookieconsent.min.css\" />\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.0.3/cookieconsent.min.js\"></script>\n" +
                "<script>\n" +
                "window.addEventListener(\"load\", function(){\n" +
                " window.cookieconsent.initialise(json)\n" +
                "});\n" +
                "</script>\n" +
                "\n" +
                "\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<g:compress>\n" +
                "\t<link rel=\"stylesheet\" href=\"/assets/css/simplePassMeter.min.css?cv=20190212_000002\" />\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" media=\"screen, print\" href=\"/assets/css/styles.css?cv=20190212_000002\"/>\n" +
                "\t<link rel=\"stylesheet\" href=\"/assets/vendor/swiper/dist/idangerous.swiper.css?cv=20190212_000002\">\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" media=\"screen, print\" href=\"/assets/css/jquery-ui-1.8.19.custom.css?cv=20190212_000002\"/>\n" +
                "</g:compress>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                "\n" +
                "\t<script type='text/javascript'>\n" +
                "\t\tvar googletag = googletag || {};\n" +
                "\t\tgoogletag.cmd = googletag.cmd || [];\n" +
                "\t\t(function() {\n" +
                "\t\tvar gads = document.createElement('script');\n" +
                "\t\tgads.async = true;\n" +
                "\t\tgads.type = 'text/javascript';\n" +
                "\t\tvar useSSL = 'https:' == document.location.protocol;\n" +
                "\t\tgads.src = (useSSL ? 'https:' : 'http:') + \n" +
                "\t\t'//www.googletagservices.com/tag/js/gpt.js';\n" +
                "\t\tvar node = document.getElementsByTagName('script')[0];\n" +
                "\t\tnode.parentNode.insertBefore(gads, node);\n" +
                "\t\t})();\n" +
                "\t</script>\n" +
                "\n" +
                "\t\t<script type=\"text/javascript\" src=\"/assets/vendor/jquery/jquery.js?cv=20190212_000002\" charset=\"utf-8\"></script>\n" +
                "\t\t\n" +
                "\n" +
                "\t\t<!--[if gt IE 8]>\n" +
                "\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/css/ie9.css?cv=20190212_000002\" />\n" +
                "\t\t<![endif]-->\n" +
                "\n" +
                "\t\t<!--[if IE 8]>\n" +
                "\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/css/ie8.css?cv=20190212_000002\" />\n" +
                "\t\t<![endif]-->\n" +
                "\n" +
                "\t\t<!--[if IE 7]>\n" +
                "\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/css/ie7.css?cv=20190212_000002\" />\n" +
                "\t\t<![endif]-->\n" +
                "\n" +
                "\t\t<!--[if IE 6]>\n" +
                "\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/css/ie6.css?cv=20190212_000002\" />\n" +
                "\t\t<![endif]-->\n" +
                "\t\t\n" +
                "\t</head>\n" +
                "\n" +
                "\t<body class=\"body-resp\">\n" +
                "\t\t<p class=\"JumpLink\" id=\"PageTop\"><a href=\"#\" title=\"Click here to Skip to main content\" accesskey=\"s\">Skip to Main Content</a></p>\n" +
                "\n" +
                "\t\t<div id=\"global-notification\" class=\"row stats-global-notification\">\n" +
                "\t\t\t<div class=\"hide col Notification Notification--global Notification--fixed\">\n" +
                "\t\t\t\t<a href class=\"Notification-close js-close\" aria-label=\"close message button\"><i class=\"fa fa-close\"></i></a>\n" +
                "\t\t\t\t<div class=\"Notification-header\"></div>\n" +
                "\t\t\t\t<div class=\"Notification-text\"></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t<div id=\"LayoutWrapper\" class=\"\">\n" +
                "\t\t\t<div class=\"container-fluid\">\n" +
                "\t\t\t\t<div class=\"row\">\n" +
                "\t\t\t\t\t<div class=\"col\">\n" +
                "\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "<!-- what is this script for? -->\n" +
                "\n" +
                "\t\n" +
                "\t\t<script type=\"text/javascript\" src=\"https://content.jwplatform.com/libraries/k2aRglnh.js\"></script>\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"Metanav stats-metanav\">\n" +
                "\t<div class=\"Metanav-ieee-links\">\n" +
                "\t\t<ul class=\"Menu Menu--horizontal Menu--dividers\">\n" +
                "\t\t\t<li class=\"Menu-item stats-extLink stats-Unav_exit_aaa\"><a href=\"http://www.ieee.org/\"  id=\"u-home\" class=\"ieeeorg\">IEEE.org</a></li>\n" +
                "\t\t\t<li class=\"Menu-item stats-extLink\">IEEE <em>Xplore</em> Digital Library</li>\n" +
                "\t\t\t<li class=\"Menu-item stats-extLink\"><a href=\"http://standards.ieee.org/\" id=\"u-standards\" class=\"exitstandardsorg\">IEEE-SA</a></li>\n" +
                "\t\t\t<li class=\"Menu-item stats-extLink\"><a href=\"http://spectrum.ieee.org/\" id=\"u-spectrum\" class=\"exitspectrum\">IEEE Spectrum</a></li>\n" +
                "\t\t\t<li class=\"Menu-item stats-extLink\"><a href=\"http://www.ieee.org/sitemap.html\" id=\"u-more\" class=\"exitmoreieeesites\">More Sites</a></li>\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "\t<div class=\"Metanav-user-links\">\n" +
                "\t\t<ul class=\"Menu Menu--horizontal Menu--dividers u-relative u-pullRight\">\n" +
                "\t\t\t\n" +
                "\t\t\t\t<li class=\"Menu-item stats-mnEvLinks\" id=\"global-header-cart-count\">\n" +
                "\t\t\t\t\t<a class=\"cart stats-Unav_exit_Cart\" href=\"https://www.ieee.org/cart/public/myCart/page.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE%20Xplore\" title=\"View Cart\" tabindex=\"0\"><span id=\"cartCount\">Cart&nbsp;(0)</span></a>\n" +
                "\t\t\t\t\t<div class=\"content-r cart-summary product-cart\"  style=\"display:none\" id=\"mc_ieee-mini-cart-include_wrapper\">\n" +
                "\t\t\t\t\t\t<a class=\"cart-close\" onClick=\"closeCart(event);\" tabindex=\"0\"></a>\n" +
                "\t\t\t\t\t\t<span style=\"display:none\" id=\"mc_ieee-mini-cart-include\"></span>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</li>\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t<li class=\"Menu-item stats-mnEvLinks\"><a class=\"create-account stats-Unav_CreateAcct\" href=\"#\" title=\"Create Account\">Create Account</a></li>\n" +
                "\t\t\t\t<li class=\"Menu-item stats-mnEvLinks\">\n" +
                "\t\t\t\t\t<a class=\"sign-in stats-Unav_P_SignIn\" href=\"#\" title=\"Sign In\">Personal Sign In</a>\n" +
                "\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "<div id=\"personal-sign-in\" class=\"hide Overlay Overlay--right stats-metanav-signin-modal\" aria-hidden=\"true\">\n" +
                "\t<div class=\"Overlay-tab\">\n" +
                "\t\t<span class=\"Overlay-label\">Personal Sign In</span>\n" +
                "\t</div>\n" +
                "\t<div class=\"Overlay-body\">\n" +
                "\t\t<div class=\"Notification hide u-mb-1\">\n" +
                "\t\t\t<div class=\"Notification-header\"></div>\n" +
                "\t\t\t<div class=\"Notification-text\"></div>\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<!-- If for signin forms that need to be hidden, use this template -->\n" +
                "\n" +
                "    \n" +
                "        <div id=\"gdpr-hidden-personal-signin-gdpr-container\" class=\"gdpr-signin-container col-md-12\">\n" +
                "            <div class=\"welcome-msg u-pb-1\">\n" +
                "                For IEEE to continue sending you helpful information on our products\n" +
                "                and services, please consent to our updated Privacy Policy.\n" +
                "            </div>\n" +
                "            <div class=\"checkbox-disclaimer row\">\n" +
                "                <div class=\"col-1\">\n" +
                "                    <label class=\"custom-checkbox\">\n" +
                "                        <input id=\"gdpr-hidden-personal-signin-gdpr-checkbox\" type=\"checkbox\" onchange=\"acceptGdpr(this)\">\n" +
                "                        <span class=\"checkmark\"></span>\n" +
                "                    </label>\n" +
                "                </div>\n" +
                "                <div class=\"col\">\n" +
                "                    I have read and accepted the <a href=\"https://www.ieee.org/security-privacy.html\" target=\"_blank\">IEEE Privacy Policy</a>.\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "        \n" +
                "            \n" +
                "\n" +
                "            \n" +
                "            <div class=\"u-pt-1 u-align-right col-12\">\n" +
                "                <button id=\"gdpr-hidden-personal-signin-back-signin-btn\" class=\"layout-btn-blue disabled\">Accept &amp; Sign In\n" +
                "            \n" +
                "        \n" +
                "        \n" +
                "               \t\t<span id=\"gdpr-hidden-personal-signin-SpinnerImage\" class=\"hide\">\n" +
                "\t\t\t\t\t\t<img  src=\"/assets/img/move-spinner.gif?cv=20190212_000002\"  ></img>\n" +
                "\t\t\t\t\t</span>\n" +
                "                </button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "       \n" +
                "        <script>\n" +
                "        \tfunction acceptGdpr(checkBox){\n" +
                "                var gdprTextBox=jQuery(\".gdpr-hidden-personal-signin\").find(\".gdprAccepted\");\n" +
                "                if(!gdprTextBox || !gdprTextBox.val() || !gdprTextBox.val()==='unknown'){\n" +
                "                \talert(\"Required \\n <input type='hidden' name='gdprAccepted' class='gdprAccepted' value='unknown' /> \\n In Form gdpr-hidden-personal-signin\")\n" +
                "                }                \n" +
                "                gdprTextBox.val(checkBox.checked);\n" +
                "        \t}\n" +
                "        \tfunction showGdpr(){\n" +
                "         \t\tjQuery(\".gdpr-hidden-personal-signin\").addClass('hidden-signin-form');\n" +
                "                jQuery('#gdpr-hidden-personal-signin-gdpr-container').show();\n" +
                "                jQuery('#gdpr-hidden-personal-signin-SpinnerImage').hide();\n" +
                "        \t}\n" +
                "        \tfunction hideGdpr(){\n" +
                "                jQuery('#gdpr-hidden-personal-signin-gdpr-container').hide();\n" +
                "                jQuery(\".gdpr-hidden-personal-signin\").removeClass('hidden-signin-form');\n" +
                "        \t}    \n" +
                "            // On GDPR checkbox click, toggle enable/disable back to sign in button.\n" +
                "            jQuery('#gdpr-hidden-personal-signin-gdpr-checkbox').change(function(){\n" +
                "                if (jQuery(this).is(':checked')) {\n" +
                "                    jQuery('#gdpr-hidden-personal-signin-back-signin-btn').removeClass('disabled');\n" +
                "                } else {\n" +
                "                    jQuery('#gdpr-hidden-personal-signin-back-signin-btn').addClass('disabled');\n" +
                "                }\n" +
                "            });\n" +
                "        \tjQuery('#gdpr-hidden-personal-signin-back-signin-btn').on('dblclick',function(event){\n" +
                "        \t\tevent.preventDefault();\n" +
                "        \t\treturn false;\n" +
                "        \t});\n" +
                "            // On Back to sign in button click, show sign in form.\n" +
                "            jQuery('#gdpr-hidden-personal-signin-back-signin-btn').click(function(){\n" +
                "            \tjQuery(this).attr(\"disabled\",\"disabled\")\n" +
                "        \t\tjQuery('#gdpr-hidden-personal-signin-SpinnerImage').show();\n" +
                "                jQuery(\".gdpr-hidden-personal-signin\").find(\".js-submit\").click();\n" +
                "            });    \n" +
                "            // On Back to sign in button click, show sign in form.\n" +
                "\n" +
                "        </script>\n" +
                "    \n" +
                "    \n" +
                "\n" +
                "\n" +
                "    \n" +
                "\t\n" +
                "     \t<script>\n" +
                "          // If checkbox is show, hide the sign in form until checkbox accepted.\n" +
                "          jQuery(document).ready(function(){\n" +
                "          \thideGdpr();\n" +
                "          });\n" +
                "        </script>\t\n" +
                "\t\n" +
                "         \n" +
                "\t\t\n" +
                "\n" +
                "\t\t<form action=\"https://ieeexplore.ieee.org/servlet/LoginModalController\" class=\"gdpr-hidden-personal-signin form-personal-signin pure-form row justify-content-center\">\n" +
                "\t\t\t\t<input\ttype=\"hidden\" name=\"src2\" id=\"src2\" value=\"loginModalWindow\" /> \n" +
                "\t\t\t\t<input\ttype=\"hidden\" name=\"url2\" id=\"url2\" value=\"/xpl/loginModal.jsp\" />\n" +
                "\t\t\t\t<div class=\"col-6 col-md-5 u-pr-1\">\n" +
                "\t\t\t\t\t<label class=\"overlabel\" for=\"username\">Email Address</label>\n" +
                "\t\t\t\t\t<input class=\"pure-input-1 username\" name=\"username\" type=\"text\" autocomplete=\"off\" placeholder=\"Email Address\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div class=\"col-6 col-md-5 u-pr-1\">\n" +
                "\t\t\t\t\t<label class=\"overlabel\" for=\"password\">Password</label>\n" +
                "\t\t\t\t\t<input class=\"pure-input-1 password\" name=\"password\" type=\"password\" placeholder=\"Password\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<input type='hidden' name='gdprAccepted' class='gdprAccepted' value='unknown' /> \n" +
                "\t\t\t\t<div class=\"col-3 col-md-2\">\n" +
                "\t\t\t\t\t<button class=\"js-submit pure-button pure-button-primary stats-Unav_Per_SignIn\">Sign In</button>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t</form>\n" +
                "\t\t<a href=\"#\" class=\"gdpr-hidden-personal-signin u-pullRight js-forgotUserPass stats-forgotUserPass stats-Unav_Per_SignIn_Forgot_UP hidden-signin-form\">Forgot Password?</a>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "\n" +
                "\t\t\t\t</li>\n" +
                "\t\t\t\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "</div> <!-- Metanav -->\n" +
                "<!--\n" +
                "TODOS\n" +
                "* update the way the shopping cart updates counts.  It's inserting string text + count.\n" +
                "* port logic for modal service unavailable to js\n" +
                " -->\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "<div class=\"Header\" id=\"xplore-header\" data-service=\"true\" data-inst=\"false\" data-web=\"false\">\n" +
                "\t<div class=\"row\">\n" +
                "\t\t<div class=\"logo-container logo-container-left\">\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<a href=\"/Xplore/home.jsp\" accesskey=\"1\" title=\"Delivering full text access to the world's highest quality technical literature in engineering and technology\" alt=\"IEEE Advancing Technology for Humanity\" class=\"logo-xplore\"></a>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t<div class=\"institutional-sign-in-container\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\t\n" +
                "\t\t<div class=\"institutional-signin\">\n" +
                "\t\t\t<i class=\"icon icon-single-caret\"></i><a class=\"u-alignMiddle\" href=\"javascript:Modal.show('/xpl/mwInstSignIn.jsp')\">Institutional Sign In</a>\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t\t<div class=\"logo-container logo-container-right\">\n" +
                "\t\t\t<span class=\"logo-ieee u-pullRight\"></span>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<!--  code for desktop capturing removed -->\n" +
                "\n" +
                "\t\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"Toolbar stats-toolbar-menu\">\n" +
                "\t<ul class=\"Toolbar-list\">\n" +
                "\t\t<li id=\"primary-browse\" class=\"Toolbar-item Toolbar-item-browse is-menu\">\n" +
                "\t\t\t<a class=\"Toolbar-button Toolbar-button-browse stats-browse-content\" tabindex=\"0\">\n" +
                "\t\t\t\t<span class=\"Toolbar-button-browse-text\">Browse<i class=\"Toolbar-dropdown-icon\"></i></span>\n" +
                "\t\t\t</a>\n" +
                "\t\t\t<ul class=\"Menu Menu--overlay Toolbar-subnav-menu Toolbar-browse-subnav-menu\">\n" +
                "\t\t\t\t<li><a href=\"/browse/books/title/\" class=\"Books stats-browse-book\">Books</a></li>\n" +
                "\t\t\t\t<li><a href=\"/browse/conferences/title/\" accesskey=\"c\" class=\"ConfProceedings stats-browse-conf\">Conferences</a></li>\n" +
                "\t\t\t\t<li><a href=\"/xpl/courses.jsp\" class=\"EducationCourses stats-browse-course\">Courses</a></li>\n" +
                "\t\t\t\t<li><a href=\"/browse/periodicals/title/\" accesskey=\"j\" class=\"Journals_Mag stats-browse-jrnl\">Journals &amp; Magazines</a></li>\n" +
                "\t\t\t\t<li><a href=\"/browse/standards/collection/ieee\" accesskey=\"b\" class=\"Standards stats-browse-std\">Standards</a></li>\n" +
                "\t\t\t\t<!-- <li>\n" +
                "\t\t\t\t\t<a tabindex=\"0\" id=\"byTopicLink\" class=\"ByTopic stats-browse-by-topic\">Topics <i class=\"Toolbar-topics-caret-icon fa fa-angle-right\"></i></a>\n" +
                "\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script>\n" +
                "\tfunction goToTopic(topic) {\n" +
                "\t\tvar topicMap = applySpecialCharacterMapping(topic); \n" +
                "\t\tvar url = \"/xpl/topicbrowse.jsp?topic=\" + escape(topicMap);\n" +
                "\t\twindow.top.location.href = url;\n" +
                "\t}\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "<div id=\"browse-by-topic\" class=\"Overlay stats-browsebytopic-menu\">\n" +
                "\t<div class=\"Overlay-body\">\n" +
                "\t\t<ul class=\"List List--no-style\">\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Aerospace\">Aerospace</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Bioengineering\">Bioengineering</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Career Development\">Career Development</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Communication, Networking & Broadcasting\">Communication, Networking & Broadcasting</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Communications\">Communications</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Components, Circuits, Devices & Systems\">Components, Circuits, Devices & Systems</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Computing\">Computing</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Computing & Processing\">Computing & Processing</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Emerging Technologies\">Emerging Technologies</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Engineered Materials, Dielectrics & Plasmas\">Engineered Materials, Dielectrics & Plasmas</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Engineering Profession\">Engineering Profession</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Fields, Waves & Electromagnetics\">Fields, Waves & Electromagnetics</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/General Topics for Engineers\">General Topics for Engineers</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Geoscience\">Geoscience</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/IEEE Standards\">IEEE Standards</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Nuclear Engineering\">Nuclear Engineering</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Photonics & Electro-Optics\">Photonics & Electro-Optics</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Power & Energy\">Power & Energy</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Power, Energy, & Industry Applications\">Power, Energy, & Industry Applications</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Robotics\">Robotics</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Robotics & Control Systems\">Robotics & Control Systems</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Signal Processing & Analysis\">Signal Processing & Analysis</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Telecommunications\">Telecommunications</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/browse/topics/Transportation\">Transportation</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "\n" +
                "\t\t\t\t</li> -->\n" +
                "\t\t\t</ul>\n" +
                "\t\t</li>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t<li class=\"Toolbar-item is-menu hide-mobile\">\n" +
                "\t\t\t<a class=\"Toolbar-button Toolbar-button-settings\" tabindex=\"0\">My Settings<i class=\"Toolbar-dropdown-icon\"></i></a>\n" +
                "\t\t\t<ul class=\"Menu Menu--overlay Toolbar-subnav-menu stats-my-settings\">\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t<li><a href=\"/xpl/tocalerts_list.jsp\" class=\"ALERTS\">Content Alerts</a></li>\n" +
                "                \t\t\t\t\t\n" +
                "\t\t\t\t<li><a href=\"/search/savedsearches\" class=\"stats-saved-searches\">Search Alerts</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t<li><a href=\"/my-settings/my-xplore\" class=\"stats-my-xplore\"><i>MyXplore</i> App</a></li>\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t<li><a href=\"/Xplore/login.jsp?reason=fromPreferencesMenu\" class=\"\" id=\"\">Preferences</a></li>\n" +
                "\t\t\t\t<li><a href=\"/articleSale/purchaseHistory.jsp\" class=\"PURCHASEHISTORY\" id=\"PURCHASEHISTORY\">Purchase History</a></li>\n" +
                "\t\t\t\t<li><a href=\"/search/searchHistoryMore.jsp\" id=\"search-history\" class=\"searchhistory\">Search History</a></li>\n" +
                "\t\t\t\t<li><a href=\"/Xplore/accessinfo.jsp\" class=\"WHATCANIACCESS\" id=\"WHATCANIACCESS\">What can I access?</a></li>\n" +
                "\t\t\t</ul>\n" +
                "\t\t</li>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t <li class=\"Toolbar-item is-menu hide-mobile\">\n" +
                "\t\t\t<a class=\"Toolbar-button Toolbar-button-help\" tabindex=\"0\">Get Help<i class=\"Toolbar-dropdown-icon\"></i></a>\n" +
                "\t\t\t<ul class=\"Menu Menu--overlay Toolbar-subnav-menu stats-get-help\">\n" +
                "\t\t\t\t<li><a href=\"/xpl/feedback.jsp\" id=\"Feedback\" >Feedback</a></li>\n" +
                "\t\t\t\t<li><a href=\"/xpl/techform.jsp\" id=\"TechSupport\">Technical Support</a></li>\n" +
                "\t\t\t\t<li><a href=\"/Xplorehelp/Help_start.html\" id=\"Resources\" >Resources and Help</a></li>\n" +
                "\t\t\t</ul>\n" +
                "\t\t</li>\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\t<li class=\"Toolbar-item Toolbar-item-subscribe hide-mobile\"><a href=\"https://innovate.ieee.org/Xplore/Subscribebutton\" target=\"_blank\" class=\"Toolbar-button Toolbar-button-subscribe stats-Xplnav_exit_subscribe\"><div class=\"Toolbar-button-subscribe-text\">Subscribe</div></a></li>\n" +
                "\t\t\n" +
                "\n" +
                "\t\t\n" +
                "\t</ul>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t\t<div id=\"global-alert-message\"></div>\n" +
                "\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\tdocument.write('<base href=\"/document/\" />');\n" +
                "\t\n" +
                "\t\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "var body_rightsLink =\"\", body_publisher = \"\";\n" +
                "var recordId = \"\";\n" +
                "\n" +
                "\n" +
                "var AUTHOR_PROFILE = 'ON';\n" +
                "if (AUTHOR_PROFILE.toUpperCase() == \"OFF\"){\n" +
                "\tvar AUTHOR_PROFILE_ENABLED = false;\n" +
                "}else{\n" +
                "\tvar AUTHOR_PROFILE_ENABLED = true;\n" +
                "}\n" +
                "\n" +
                "var global = {\n" +
                "\tdocument: {\n" +
                "\t\tdisqus:{\n" +
                "\t\t\tremote_auth_s3 : '',\n" +
                "\t\t\tpublic_api_key:'1lxKgMbpNIbQvfk2tqLcWeSVloE8rgIY2CV1tCu3Vp641oL4eEITYBbkViJJGNYY',\n" +
                "\t\t\tshort_name:'ieeexplore',\n" +
                "\t\t\tclient_url:'https://ieeexplore.ieee.org',\n" +
                "\t\t\tsso_enabled:'{$sessionProfile.provisioned}'\n" +
                "\t\t},\n" +
                "\n" +
                "\t\tfullTextAccess: false,\n" +
                "\t\tisAccessFromInstitution: false\n" +
                "\t\t\n" +
                "\t}\n" +
                "};\n" +
                "\t\n" +
                "\tglobal.document.metadata={\"userInfo\":{\"institute\":false,\"member\":false,\"individual\":false,\"guest\":false,\"subscribedContent\":false,\"fileCabinetContent\":false,\"fileCabinetUser\":false,\"institutionalFileCabinetUser\":false,\"showPatentCitations\":true,\"showGet802Link\":false,\"showOpenUrlLink\":false},\"authors\":[{\"name\":\"Fan-Xu Meng\",\"affiliation\":\"State Key Laboratory of Millimeter Waves, Southeast University, Nanjing, China\",\"bio\":{\"graphic\":\"/mediastore_new/IEEE/content/freeimages/6287639/8600701/8574891/meng-2886581-small.gif\",\"p\":[\"Fan-Xu Meng received the B.S. degree in information and computing science from the Nanjing University of Aeronautics and Astronautics, Nanjing, China, in 2012, and the M.S. degree in electromagnetic field and microwave technology from Southeast University, Nanjing, China, in 2015, where he is currently pursuing the Ph.D. degree in electronic science and technology. His recent research interests include quantum computation, quantum machine learning, and quantum communication.\"]},\"firstName\":\"Fan-Xu\",\"lastName\":\"Meng\",\"affiliation\":\"State Key Laboratory of Millimeter Waves, Southeast University, Nanjing, China\",\"orcid\":\"0000-0002-7335-2491\",\"id\":\"37086586274\"},{\"name\":\"Xu-Tao Yu\",\"affiliation\":\"State Key Laboratory of Millimeter Waves, Southeast University, Nanjing, China\",\"bio\":{\"graphic\":\"/mediastore_new/IEEE/content/freeimages/6287639/8600701/8574891/yu-2886581-small.gif\",\"p\":[\"Xu-Tao Yu received the Ph.D. degree from the National Mobile Communication Research Laboratory, Southeast University, Nanjing, China, in 2004. She is currently a Full Professor with the State Key Laboratory of Millimeter Waves, Southeast University. Her current research interests include quantum computing in wireless networks and quantum communication networks.\"]},\"firstName\":\"Xu-Tao\",\"lastName\":\"Yu\",\"affiliation\":\"State Key Laboratory of Millimeter Waves, Southeast University, Nanjing, China\",\"orcid\":\"0000-0001-8625-3241\",\"id\":\"37293162900\"},{\"name\":\"Rui-Qing Xiang\",\"affiliation\":\"Department of Electrical Engineering and Computer Science, University of California Berkeley at Berkeley, Berkeley, CA, USA\",\"bio\":{\"graphic\":\"/mediastore_new/IEEE/content/freeimages/6287639/8600701/8574891/xiang-2886581-small.gif\",\"p\":[\"Rui-Qing Xiang is currently pursuing the B.A. degree in computer science and applied math with the University of California at Berkeley, Berkeley, CA, USA. He assisted research, in 2018.\"]},\"firstName\":\"Rui-Qing\",\"lastName\":\"Xiang\",\"affiliation\":\"Department of Electrical Engineering and Computer Science, University of California Berkeley at Berkeley, Berkeley, CA, USA\",\"id\":\"37086588673\"},{\"name\":\"Zai-Chen Zhang\",\"affiliation\":\"National Mobile Communications Research Laboratory, Southeast University, Nanjing, China\",\"bio\":{\"graphic\":\"/mediastore_new/IEEE/content/freeimages/6287639/8600701/8574891/zhang-2886581-small.gif\",\"p\":[\"Zai-Chen Zhang was born in Nanjing, China, in 1975. He received the B.S. and M.S. degrees in electrical and information engineering from Southeast University, Nanjing, China, in 1996 and 1999, respectively, and the Ph.D. degree in electrical and electronic engineering from The University of Hong Kong, Hong Kong, in 2002. From 2002 to 2004, he was a Post-Doctoral Fellow with the National Mobile Communications Research Laboratory, Southeast University, China. He joined the School of Information Science and Engineering, Southeast University, in 2004, where he is currently a Professor. He has published over 200 papers and issued 30 patents. His current research interests include beyond 5G intelligent wireless systems, optical wireless communications, and quantum information technologies.\"]},\"firstName\":\"Zai-Chen\",\"lastName\":\"Zhang\",\"affiliation\":\"National Mobile Communications Research Laboratory, Southeast University, Nanjing, China\",\"orcid\":\"0000-0003-4301-8713\",\"id\":\"37086588960\"}],\"issn\":[{\"format\":\"Electronic ISSN\",\"value\":\"2169-3536\"}],\"articleNumber\":\"8574891\",\"dbTime\":\"4 ms\",\"metrics\":{\"citationCountPaper\":0,\"citationCountPatent\":0,\"totalDownloads\":73},\"sponsors\":[{\"packageNumber\":0,\"name\":\"IEEE\",\"url\":\"http://www.ieee.org/index.html\"}],\"pdfUrl\":\"/stamp/stamp.jsp?tp=&arnumber=8574891\",\"purchaseOptions\":{\"showOtherFormatPricingTab\":false,\"showPdfFormatPricingTab\":true,\"pdfPricingInfoAvailable\":true,\"otherPricingInfoAvailable\":false,\"mandatoryBundle\":false,\"optionalBundle\":false,\"pdfPricingInfo\":[{\"memberPrice\":\"$14.95\",\"nonMemberPrice\":\"$33.00\",\"partNumber\":\"8574891\",\"type\":\"PDF/HTML\"}]},\"formulaStrippedArticleTitle\":\"Quantum Algorithm for Spectral Regression for Regularized Subspace Learning\",\"getProgramTermsAccepted\":false,\"sections\":{\"abstract\":\"true\",\"authors\":\"true\",\"figures\":\"true\",\"multimedia\":\"false\",\"references\":\"true\",\"citedby\":\"false\",\"keywords\":\"true\",\"definitions\":\"false\",\"algorithm\":\"false\",\"supplements\":\"false\",\"footnotes\":\"false\",\"disclaimer\":\"false\",\"metrics\":\"true\"},\"title\":\"Quantum Algorithm for Spectral Regression for Regularized Subspace Learning\",\"abstract\":\"In this paper, we propose an efficient quantum algorithm for spectral regression which is a dimensionality reduction framework based on the regression and spectral graph analysis. The quantum algorithm involves two core subroutines: the quantum principal eigenvectors analysis and the quantum ridge regression algorithm. The quantum principal eigenvectors analysis can be performed by an efficient sparse Hamiltonian simulation. For the ridge regression, we propose a quantum algorithm that is derived from the quantum singular value decomposition method. Our quantum ridge regression algorithm is more suitable for data matrices that are non-sparse and skewed. Our analysis demonstrates that the quantum subroutines can be implemented with an approximatively polynomial speedup on a quantum computer over their classical counterparts.\",\"pubLink\":\"/xpl/RecentIssue.jsp?punumber=6287639\",\"issueLink\":\"/xpl/tocresult.jsp?isnumber=8600701\",\"standardTitle\":\"Quantum Algorithm for Spectral Regression for Regularized Subspace Learning\",\"keywords\":[{\"type\":\"IEEE Keywords\",\"kwd\":[\"Sparse matrices\",\"Symmetric matrices\",\"Dimensionality reduction\",\"Machine learning algorithms\",\"Phase estimation\",\"Eigenvalues and eigenfunctions\",\"Matrix decomposition\"]},{\"type\":\"Author Keywords \",\"kwd\":[\"Spectral regression\",\"dimensionality reduction\",\"quantum principal eigenvectors analysis\",\"quantum ridge regression\"]}],\"allowComments\":true,\"doi\":\"10.1109/ACCESS.2018.2886581\",\"publicationTitle\":\"IEEE Access\",\"startPage\":\"4825\",\"endPage\":\"4832\",\"displayPublicationTitle\":\"IEEE Access\",\"pdfPath\":\"/iel7/6287639/8600701/08574891.pdf\",\"rightsLink\":\"http://s100.copyright.com/AppDispatchServlet?publisherName=ieee&publication=2169-3536&title=Quantum+Algorithm+for+Spectral+Regression+for+Regularized+Subspace+Learning&isbn=&publicationDate=2019&author=Fan-Xu+Meng&ContentID=10.1109/ACCESS.2018.2886581&orderBeanReset=true&startPage=4825&endPage=4832&volumeNum=7\",\"isJournal\":true,\"isConference\":false,\"dateOfInsertion\":\"10 January 2019\",\"isGetArticle\":false,\"isGetAddressInfoCaptured\":false,\"isMarketingOptIn\":false,\"xploreDocumentType\":\"Journals & Magazine\",\"applyOUPFilter\":false,\"isStandard\":false,\"isPromo\":false,\"persistentLink\":\"https://ieeexplore.ieee.org/servlet/opac?punumber=6287639\",\"journalDisplayDateOfPublication\":\"13 December 2018\",\"htmlAbstractLink\":\"/document/8574891/\",\"isOUP\":false,\"isDynamicHtml\":true,\"isFreeDocument\":true,\"isSMPTE\":false,\"isCustomDenial\":false,\"isNotDynamicOrStatic\":false,\"chronOrPublicationDate\":\"2019\",\"publisher\":\"IEEE\",\"isACM\":false,\"volume\":\"7\",\"isProduct\":false,\"isEphemera\":false,\"publicationDate\":\"2019\",\"isEarlyAccess\":false,\"isBook\":false,\"isChapter\":false,\"isStaticHtml\":false,\"isMorganClaypool\":false,\"isOpenAccess\":true,\"htmlLink\":\"/document/8574891/\",\"startPage\":\"4825\",\"fundingAgencies\":{\"fundingAgency\":[{\"fundingId\":\"10.13039/501100001809\",\"fundingName\":\"National Natural Science Foundation of China\"}]},\"openAccessFlag\":\"T\",\"ephemeraFlag\":\"false\",\"title\":\"Quantum Algorithm for Spectral Regression for Regularized Subspace Learning\",\"graphicalAbstract\":{\"summary\":\"Quantum circuit diagram of ridge regression in Spectral Regression with a polynomial speedup.\",\"type\":\"graphic\",\"fileSize\":\"35KB\",\"file\":\"/ielx7/6287639/8600701/8574891/graphical_abstract/access-gagraphic-2886581.jpg\",\"coverImage\":\"/ielx7/6287639/8600701/8574891/graphical_abstract/access-gagraphic-2886581.jpg\"},\"html_flag\":\"false\",\"ml_html_flag\":\"true\",\"sourcePdf\":\"access-yu-2886581-x.pdf\",\"content_type\":\"Journals & Magazines\",\"mlTime\":\"PT0.097333S\",\"chronDate\":\"2019\",\"xplore-pub-id\":\"6287639\",\"pdfPath\":\"/iel7/6287639/8600701/08574891.pdf\",\"isNumber\":\"8600701\",\"dateOfInsertion\":\"10 January 2019\",\"contentType\":\"periodicals\",\"publicationDate\":\"2019\",\"publicationNumber\":\"6287639\",\"xplore-issue\":\"8600701\",\"articleId\":\"8574891\",\"publicationTitle\":\"IEEE Access\",\"sections\":{\"abstract\":\"true\",\"authors\":\"true\",\"figures\":\"true\",\"multimedia\":\"false\",\"references\":\"true\",\"citedby\":\"false\",\"keywords\":\"true\",\"definitions\":\"false\",\"algorithm\":\"false\",\"supplements\":\"false\",\"footnotes\":\"false\",\"disclaimer\":\"false\",\"metrics\":\"true\"},\"volume\":\"7\",\"onlineDate\":\"13 December 2018\",\"publisher\":\"IEEE\",\"publicationYear\":\"2019\",\"subType\":\"IEEE Journal\",\"lastupdate\":\"2019-01-22\",\"mediaPath\":\"/mediastore_new/IEEE/content/media/6287639/8600701/8574891\",\"endPage\":\"4832\",\"displayPublicationTitle\":\"IEEE Access\",\"doi\":\"10.1109/ACCESS.2018.2886581\"};\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div ng-app=\"xpl.document\">\n" +
                "\t\n" +
                "\t\n" +
                "\t\t<xpl-searchbar show-count=\"false\"></xpl-searchbar>\n" +
                "\t\n" +
                "\t<div class=\"global-content-wrapper\">\n" +
                "\t\t<xpl-root>\n" +
                "\t\t\t<div class=\"Spinner\"></div>\n" +
                "\t\t</xpl-root>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<!-- START: Angular 2+ Migration: Due to Angualr2+ migration AngualrJs router place holder commented -->\n" +
                "<!-- \t<div ng-show=\"stateIsLoading\" class=\"Spinner\"></div>\n" +
                "\t<div ui-view class=\"{{stateIsLoading ? 'loading': ''}}\"\n" +
                "\t\tautoscroll=\"false\"></div>\n" +
                " -->\t<!-- END: Angular 2+ Migration-->\n" +
                "</div>\n" +
                "\n" +
                "\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<section id=\"xploreFooter\">\n" +
                "\t\n" +
                "\t<div class=\"Footer stats-footer hide-mobile\">\n" +
                "\t\t<div class=\"pure-g Footer-sections\">\n" +
                "\t\t\t<div class=\"pure-u-1-4\">\n" +
                "\t\t\t\t<h3 class=\"Footer-header\">IEEE Account</h3>\n" +
                "\t\t\t\t<ul class=\"Footer-list\">\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/changeusrpwd/showChangeUsrPwdPage.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Change Username/Password</a></li>\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/address/getAddrInfoPage.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Update Address</a></li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"pure-u-1-4\">\n" +
                "\t\t\t\t<h3 class=\"Footer-header\">Purchase Details</h3>\n" +
                "\t\t\t\t<ul class=\"Footer-list\">\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/payment/showPaymentHome.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Payment Options</a></li>\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/vieworder/showOrderHistory.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Order History</a></li>\n" +
                "\t\t\t\t\t<li><a href=\"/articleSale/purchaseHistory.jsp\">View Purchased Documents</a></li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"pure-u-1-4\">\n" +
                "\t\t\t\t<h3 class=\"Footer-header\">Profile Information</h3>\n" +
                "\t\t\t\t<ul class=\"Footer-list\">\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/commprefs/showcommPrefpage.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Communications Preferences</a></li>\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/profedu/getProfEduInformation.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Profession and Education</a></li>\n" +
                "\t\t\t\t\t<li><a href=\"https://www.ieee.org/profile/tips/getTipsInfo.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore\">Technical Interests</a></li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"pure-u-1-4\">\n" +
                "\t\t\t\t<h3 class=\"Footer-header\">Need Help?</h3>\n" +
                "\t\t\t\t<ul class=\"Footer-list\">\n" +
                "\t\t\t\t\t<li><strong>US &amp; Canada:</strong> +1 800 678 4333</li>\n" +
                "\t\t\t\t\t<li><strong>Worldwide: </strong> +1 732 981 0060<br>\n" +
                "\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t<li><a href=\"/xpl/techform.jsp\">Contact &amp; Support</a></li>\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"row\">\n" +
                "\t\t\t<div class=\"col-12 Footer-bottom\">\n" +
                "\t\t\t\t<div class=\"Footer-bottom-inner-div row\">\n" +
                "\t\t\t\t\t<div class=\"col\">\n" +
                "\t\t\t\t\t\t<ul class=\"Menu Menu--horizontal Menu--dividers u-mb-1\">\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"/Xplorehelp/about-ieee-xplore.html\">About IEEE <em>Xplore</em></a></li>\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"/xpl/techform.jsp\">Contact Us</a></li>\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"/Xplorehelp/Help_start.html\" target=\"blank\">Help</a></li>\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"/Xplorehelp/accessibility-statement.html\" target=\"blank\">Accessibility</a></li> \n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"/Xplorehelp/Help_Terms_of_Use.html\" target=\"_blank\">Terms of Use</a></li>\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"http://www.ieee.org/web/aboutus/whatis/policies/p9-26.html\">Nondiscrimination Policy</a></li>\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"/xpl/sitemap.jsp\">Sitemap</a></li>\n" +
                "\t\t\t\t\t\t\t<li class=\"Menu-item\"><a href=\"http://www.ieee.org/about/help/security_privacy.html\" target=\"blank\">Privacy &amp; Opting Out of Cookies</a></li>\n" +
                "\t\t\t\t\t\t</ul>\n" +
                "\t\t\t\t\t\t<p class=\"Footer-bottom-terms\">\n" +
                "\t\t\t\t\t\t\tA not-for-profit organization, IEEE is the world's largest technical professional organization dedicated to advancing technology for the benefit of humanity.<br>&copy; Copyright 2019 IEEE - All rights reserved. Use of this web site signifies your agreement to the terms and conditions.\n" +
                "\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t<div><i class=\"logo-ieee-white\"></i></div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "</section>\n" +
                "\n" +
                "\t\t\t\t\t\t<!-- BEGIN: tealium in v2/common/template.jsp. We need to include tealiumAnalytics.js here since Angular 2+ app load if you load after commnon.js then tealium value will not be available in angular 2+ app  -->\n" +
                "\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t<!-- BEGIN: TealiumAnalytics.jsp -->\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\n" +
                "\t\t\t<script type =\"text/javascript\">\n" +
                " \t\t\t\t// tealium config vars\n" +
                "\t\t\t\tvar TEALIUM_CONFIG_TAGGING_ENABLED = true;\t\t\n" +
                "\t\t\t\tvar TEALIUM_CONFIG_CDN_URL = '//tags.tiqcdn.com/utag/';\n" +
                "\t\t\t\tvar TEALIUM_CONFIG_ACCOUNT_PROFILE_ENV = 'ieeexplore/main/prod';\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t// tealium utag_data values for user \n" +
                "\t\t\t\tvar TEALIUM_userType = 'Anonymous';\n" +
                "\t\t\t\tvar TEALIUM_userInstitutionId = '';\n" +
                "\t\t\t\tvar TEALIUM_userId = '';\n" +
                "\t\t\t\tvar TEALIUM_user_third_party = '';\n" +
                "\t\t\t\t\n" +
                "\t\t\t\tvar TEALIUM_products = '';\n" +
                "\t\t\t</script>\n" +
                "\n" +
                "\n" +
                "\t\t\t<script type=\"text/javascript\">\n" +
                "\t\t\t// asynchronously load tealium's utag.js , which declares tealium JS variables like; utag_data, utag\n" +
                "\t\t\t(function(a,b,c,d){\n" +
                "\t\t\t\n" +
                "\t\t\t\ta=TEALIUM_CONFIG_CDN_URL + TEALIUM_CONFIG_ACCOUNT_PROFILE_ENV + '/utag.js';\n" +
                "\t\t\t\tb=document;c='script';d=b.createElement(c);d.src=a;\n" +
                "\t\t\t\td.type='text/java'+c;d.async=true;\n" +
                "\t\t\t\ta=b.getElementsByTagName(c)[0];a.parentNode.insertBefore(d,a);\n" +
                "\t\t\t})();\n" +
                "\t\t\t</script>\n" +
                "\n" +
                "\t\t\t<script type=\"text/javascript\" src=\"/assets/js/analytics/tealiumTagsData.js?cv=20190212_000002\"></script>\n" +
                "\t\t\t<script type=\"text/javascript\" src=\"/assets/js/analytics/tealiumAnalytics.js?cv=20190212_000002\"></script>\n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                " \t\t\n" +
                "\t\t<!-- END: TealiumAnalytics.jsp -->\n" +
                "\t\t\t \n" +
                "\n" +
                "\t\t\t\t\t\t<!-- END: tealium in v2/common/template.jsp -->\n" +
                "\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"/assets/css/ie7Sniffer.css?cv=20190212_000002\">\n" +
                "<script type=\"text/javascript\" src=\"/assets/vendor/js-cookie/src/js.cookie.js?cv=20190212_000002\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/assets/vendor/fingerprintjs2/fingerprint2.js?cv=20190212_000002\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/assets/js/lib/core/fingerprint.js?cv=20190212_000002\"></script>\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\n" +
                "\t\t\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"width: 1263px;\" id=\"popup_overlay\"></div>\n" +
                "\n" +
                "<g:compress>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/vendor/modernizr/modernizr.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/js/vendor.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                " \n" +
                "<script>\n" +
                "\tvar $j = jQuery.noConflict();\n" +
                "\tvar j$ = jQuery.noConflict();\n" +
                "\tvar membershipIncomplete;\n" +
                "    var IS_INDIVIDUAL_USER=false;\n" +
                "\n" +
                "\tvar searchPropertiesParamQueryText = 'queryText';\n" +
                "\tvar searchPropertiesParamNewSearch = 'newsearch';\n" +
                "\tvar searchPropertiesParamMatchBoolean = 'matchBoolean';\n" +
                "\tvar searchPropertiesParamSearchWithin = 'searchWithin';\n" +
                "\tvar searchInterfaceArticleIndexTermReference = 'Search_Index_Terms';\n" +
                "\tvar searchPropertiesParamRecordsPerPage = 'rowsPerPage';\n" +
                "\tvar searchPropertiesParamPageNumber = 'pageNumber';\n" +
                "\tvar searchPropertiesParamRemoveRefinement = 'removeRefinement';\t\n" +
                "\tvar searchPropertiesParamSearchField = 'searchField';\n" +
                "\tvar searchPropertiesParamArticleNumber = 'arnumber';\n" +
                "\t\n" +
                "\tvar authorsGetDisplay = 'Authors';\n" +
                "\tvar authorsFirstNameProperty = 'First Name';\n" +
                "\tvar authorsLastNameProperty = 'Last Name';\n" +
                "\tvar authorsMiddleNameProperty = 'Middle Name';\n" +
                "\tvar pubTitleDispNameProperty = 'Publication Title';\n" +
                "\tvar volumeDispNameProperty = 'Volume';\n" +
                "\tvar issueDispNameProperty = 'Issue';\n" +
                "\tvar startPageDispNameProperty = 'Start Page';\n" +
                "\tvar endPageDispNameProperty = 'Start Page';\n" +
                "\n" +
                "\tvar searchIcsTermProperty = 'Standards ICS Terms';\n" +
                "\tvar SearchMapperParamSearchField = 'searchField';\n" +
                "\t\n" +
                "\tvar SearchMapperParamNewSearch = 'newsearch';\n" +
                "\tvar SearchMapperParamArticleNumber = 'arnumber';\t\n" +
                "\t\n" +
                "\tvar NTPT_IMAGE_LOCATION = '';\n" +
                "\tvar XPLORE_SSL_HOST = 'https://ieeexplore.ieee.org';\t\n" +
                "\tvar SSL_YES_NO = 'yes';\n" +
                "\tif (SSL_YES_NO.toUpperCase() == \"NO\"){\n" +
                "\t\tvar XPLORE_SSL_YES_NO = false;\n" +
                "\t}else{\n" +
                "\t\tvar XPLORE_SSL_YES_NO = true;\n" +
                "\t}\n" +
                "\tvar WEBSERVICES_SSL_YES_NO = 'yes';\n" +
                "\tif (WEBSERVICES_SSL_YES_NO.toUpperCase() == \"NO\"){\n" +
                "\t\tvar XPLORE_WEBSERV_YES_NO = false;\n" +
                "\t}else{\n" +
                "\t\tvar XPLORE_WEBSERV_YES_NO = true;\n" +
                "\t}\n" +
                "\t\n" +
                "\tvar AUTHOR_PROFILE = 'ON';\n" +
                "\tif (AUTHOR_PROFILE.toUpperCase() == \"OFF\"){\n" +
                "\t\tvar AUTHOR_PROFILE_ENABLED = false;\n" +
                "\t}else{\n" +
                "\t\tvar AUTHOR_PROFILE_ENABLED = true;\n" +
                "\t}\n" +
                "\t\n" +
                "\tvar ILN_SWITCH = 'OFF';\n" +
                "\tif (ILN_SWITCH.toUpperCase() == \"OFF\"){\n" +
                "\t\tvar ILN_ENABLED = false;\n" +
                "\t}else{\n" +
                "\t\tvar ILN_ENABLED = true;\n" +
                "\t}\n" +
                "\t\n" +
                "\tvar IBP_MEMBEER_SIGNIN_TIME_WAIT_IN_MILLIES = '800';\n" +
                "\tvar ASSETS_RELATIVE_PATH = '/assets'; // NOTE: AngularJS code relies on this\n" +
                "\tvar ASSETS_RELATIVE_PATH_NO_SERVER = '/assets';\n" +
                "\tvar ASSETS_VERSION = '20190212_000002'; // NOTE: AngularJS code relies on this\n" +
                "\tvar IBP_WS_ASSETS='https://www.ieee.org';\n" +
                "\tvar IBP_WS_ENABLED_FLAG = true;\n" +
                "\tvar ENTERPRISE_CART_URL = 'https://www.ieee.org/cart/public/myCart/page.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE%20Xplore';\n" +
                "\n" +
                "\tvar SPECIAL_CHARACTER_MAPS = '&:.AND.,=:.EQ.,+:.PLS.,#:.HSH.';\n" +
                "\tvar SPECIAL_CHARACTERS = new Array();\n" +
                "\tvar SPECIAL_CHARACTER_REPLACEMENTS = new Array();\n" +
                "\tvar characterMaps = SPECIAL_CHARACTER_MAPS.split(\",\");\n" +
                "\tfor (var i = 0; i < characterMaps.length; i++) {\n" +
                "\t\tparts = characterMaps[i].split(\":\");\n" +
                "\t\tSPECIAL_CHARACTERS[i] = parts[0];\n" +
                "\t\tSPECIAL_CHARACTER_REPLACEMENTS[i] = parts[1];\n" +
                "\t}\n" +
                "\n" +
                "\tvar ALL_SEARCH_FIELDS = 'Search_Index_Terms:Index Terms,Search_All_Text:Full Text & Metadata,Search_All:Metadata Only,Search_Publication_Title:Search Publication Title,Search_Related_Terms:Search Related Terms,Search_Authors:Author Name,Search_Standard_Ics_Title:ICE Terms,id:Article Number,id:ID,moduleNumber:Module Number,part_num:Part_Num,issn:ISSN,isbn:ISBN,eisbn:EISBN,issueId:IS Number,pubIssueId:Pub Issue Id,accessionNumber:Accession Number,copyrightHolder:Copyright Holder,copyrightYear:Copyright Year,license:License,title:Document Title,documentAbstract:Abstract,publicationId:Publication Number,parentId:Parent Publication Number,parentTitle:Parent Publication Title,publicationTitle:Publication Title,publicationDisplayTitle:Publication Display Title,volume:Volume,issue:Issue,paddedIssueNumber:Padded Issue Number,part:Part,startPage:Start Page,endPage:End Page,filePath:File Path,publicationDate:Publication Date,PublicationYear:Publication_Year,onlineDate:Online Date,month:Month,Author:Author Pref Names,authorNormNames:Author Norm Names,author:Authors,authorIds:Author Ids,firstName:First Name,middleName:Middle Name,lastName:Last Name,Affiliation:Author Affiliations,authorBio:Author Bio,authorImg:Author Img,referenceCount:Reference Count,citationCount:Citation Count,patentCount:Patent Count,multimediaFlag:Multimedia Flag,biomedicalEngFlag:Biomedical Eng Flag,nonIeee:Non IEEE,stdsProductNumber:STDS Product Number,status:Status,doi:DOI,pdfPath:Pdf Path,pdfSize:Pdf Size,contentType:Content Type,Publisher:Publisher,ControlledTerms:INSPEC Controlled Terms,freeTerms:INSPEC Non-Controlled Terms,ieeeTerms:IEEE Terms,authorTerms:Author Keywords,maiTerms:MAI Terms,meshTerms:Mesh_Terms,pacsTerms:PACS Terms,insertDate:Insert Date,conferenceLocation:Conference Location,indexContent:Index Content,coden:CODEN,documentText:Document Text,standardNumber:Standard Number,preprintFlag:Preprint Flag,rapidPostFlag:Rapid Post Flag,lastUpdate:Last Update,newFlag:New Flag,openAccessFlag:Open Access Flag,publicationOpenAccess:Publication Open Access,promoFlag:Promo Flag,pubmedId:Pubmed Id,duration:Duration,society:Society,conference:Conference,societyUrl:Society URL,idSubject:Id Subject,bookNumber:Book Number,pages:Pages,editionNumber:Edition Number,sequence:Sequence,relatedInfoType:Related Info Type,relatedInfo:Related Info,formatIsbn:Format ISBN,meetingDate:Meeting Date,courseLevel:Course level,courseId:Course ID,aboutUrl:About Url,additionalUrl:Additional Url,authorsUrl:Authors Url,openAccessUrl:Open Access Url,openAccessFlag:Open Access flag,partnumVendorurlMediatype:Partnum VendorURL MediaType,brandingImageFile:Branding Image File,coverImageFile:Cover Image File,frequency:Frequency,fieldOfInterest:Field Of Interest,gParentPublicationNumber:G Parent Publication Number,msUrl:Ms Url,relationship:Relationship,societyImage:Society Image,visitUrl:Visit Url,visitWebsite:Visit Website,startYear:Start Year,endYear:End Year,recordType:Record Type,rollukey:RolluKey,epub:Epub,picCodeDescription:Pic Code Description,picCode:Pic Code,sponsors:Sponsors,notes:Notes,conferenceDate:Conference Date,publicationContact:Publication Contact,isbuyable:isBuyable,publicationFiles:Publication Files,standardRelationships:Standard Relationships,unavailableForSale:Unavailable for Sale,standardFamily:Standard Family,standardGroup:Standard Group,productUrl:Product Url,isbnMediatype:ISBN MediaType,htmlFlag:Html Flag,rightslinkFlag:Rightslink Flag,pageCount:Page Count,name:Name,tableOfContents:Table of Contents,timeStamp:Time Stamp,subTitle:Sub Title,relatedItem:Related Item,referenceMaterial:Reference Material,latestIssueTime:Latest Issue Time,insertDate:Search Latest Date,pbdFlag:Pbd Flag,lmsUrl:Lms Url,currentVolume:Current Volume,graphicalFile:Graphical File,graphicalCoverImage:Graphical Cover Image,graphicalSummary:Graphical Summary,graphicalType:Graphical Type,authorNativeNames:Native Name,externalId:Article Page Number,standardBundles:Standard Bundles,standardBundleParts:Standard Bundle Parts,virtualTitle:Virtual Title,seriesName:Series Name,seriesId:Series Id,mlHtmlFlag:ML Html flag,promoDates:Promo Dates,promoStartDate:Promo Start Date,promoEndDate:Promo End Date,issueCompleteFlag:Issue Complete Flag,scope:Scope,purpose:Purpose,standardFamilyTitle:Standard Family Title,thumbnailImg:Thumbnail Img,supplementFile:Supplement File,courseFile:Course File,supplement:Supplement,courseAuthor:Course Author,pdhs:Pdhs,ceus:Ceus,courseFirstFrame:FirstFrame Img,idSubTopic:Id Sub Topic,certificateUrl:Certificate Url,standardRoot:Standard Root,icsTerms:Standards ICS Terms,impactStatement:Impact Statement,plagiarizedFlag:Plagiarized Flag,affirmedDate:Affirmed Date,sourcePdf:Source Pdf,orcid:Author ORCID,algorithmFlag:Algorithm Flag,fundingAgency:Funding Agency,pricingKey:Map Pricing Key,rollupKey:Rollup Key,collection:Collection,previewImage:Preview Image,regularDate:Regular Date,TypeAheadTerms:Type Ahead Terms,IeeeTerm:IEEE Term,ContentType:Content Type,Author:Author,Affiliation:Affiliation,Topic:Topic,PublicationTitle:Publication Title,PublicationYear:Year,Publisher:Publisher,ConferenceCountry:Conference Country,ConferenceLocation:Conference Location,StandardStatus:Standard Status,ConferenceYear:Conference Year,PublicationPackage:Subscribed Content,StandardPackage:Standard Package,StandardTitle:Standard Title,StdDictionaryTerms:Standards Dictionary Terms,TitleRange:Publication Range,StandardRange:Standard Range,RecordType:Record Type,MediaType:Media Type,BookType:Book Type,CourseType:Course Type,PublicationStandardRange:Publication Standard Range,PerpetualYear:Perpetual Year,OpacTitleRange:Opac Title Range,BookSeries:Book Series,SubjectCategory:Subject Category,TypeAheadPublication:Type Ahead Publication,SubTopic:Sub Topic,CourseDuration:Course Duration,CourseLevel:Course Level,StandardType:Standard Type,StandardSubtype:Standard SubType,Topic:Standard Topic,StandardModifier:Standard Modifier,IcsTerms1:Ics Terms 1,IcsTerms2:Ics Terms 2,IcsTerms3:Ics Terms 3,SupplementalItem:Supplemental Items,CourseDuration:Course Duration,SpecialSection:Topics,ControlledTerms:Index Terms';\n" +
                "\tvar SEARCH_FIELD_REFERENCES = new Array();\n" +
                "\tvar SEARCH_FIELD_DISPLAYS = new Array();\n" +
                "\tvar searchFields = ALL_SEARCH_FIELDS.split(\",\");\n" +
                "\tfor (var j = 0; j < searchFields.length; j++) {\n" +
                "\t\tparts = searchFields[j].split(\":\");\n" +
                "\t\tSEARCH_FIELD_REFERENCES[j] = parts[0];\n" +
                "\t\tSEARCH_FIELD_DISPLAYS[j] = parts[1];\n" +
                "\t}\n" +
                "\t\n" +
                "\n" +
                "\tvar refSite='https://ieeexplore.ieee.org';\n" +
                "\tvar refSiteName=\"IEEE Xplore\";\n" +
                "\tvar applicationName = 'Xplore';\n" +
                "\tvar MC_OPERATION_DELAY_TIMEOUT='5000';\n" +
                "\tvar MC_ADDING_DELAY_MSG='Please wait.The selected item(s) is being added to the cart.';\n" +
                "\tvar MC_TIMEOUT='60000';\n" +
                "\tvar MC_OPERATION_DELAY_MSG_FLAG='true';\n" +
                "\n" +
                "\tvar MEMBER_PROFILE_CHANGE_USERNAMEPASS_LINK = 'https://www.ieee.org/profile/changeusrpwd/showChangeUsrPwdPage.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar MEMBER_PROFILE_ADDRESSINFO_LINK = 'https://www.ieee.org/profile/address/getAddrInfoPage.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar MEMBER_PROFILE_PAYMENTINFO_LINK = 'https://www.ieee.org/profile/payment/showPaymentHome.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar MEMBER_PROFILE_ORDER_HISTORY_LINK = 'https://www.ieee.org/profile/vieworder/showOrderHistory.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar MEMBER_USER_COMMUNICATION_LINK = 'https://www.ieee.org/profile/commprefs/showcommPrefpage.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar MEMBER_EDUCATIONAL_PROFILE_LINK = 'https://www.ieee.org/profile/profedu/getProfEduInformation.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar MEMBER_TECHNICAL_INTERESTS_LINK = 'https://www.ieee.org/profile/tips/getTipsInfo.html?refSite=http://ieeexplore.ieee.org&refSiteName=IEEE Xplore';\n" +
                "\tvar HELPFILE_RELATIVE_PATH = '/Xplorehelp';\n" +
                "\t\n" +
                "\t//content types\n" +
                "\tvar CONTENT_TYPE_PARAM = 'contentType';\n" +
                "\tvar CONTENT_TYPE_BOOKS = 'Books';\n" +
                "\tvar CONTENT_TYPE_COURSES = 'Courses';\n" +
                "\tvar CONTENT_TYPE_STANDARDS = 'Standards';\n" +
                "\tvar CONTENT_TYPE_CONFERENCES = 'Conferences';\n" +
                "\tvar CONTENT_TYPE_JOURNALS = 'Journals & Magazines';\n" +
                "\tvar CONTENT_TYPE_EARLY_ACCESS = 'Early Access Articles';\n" +
                "\t\n" +
                "\t//User Preferences\n" +
                "\tvar citFormat = \"\";\n" +
                "\tvar dlFormat = \"\";\n" +
                "\t\n" +
                "\t//Google ReCaptcha public Key \n" +
                "\tvar RECAPTCHA_PUBLIC_KEY = '6Ld6GEUUAAAAALdaAmeGUhZyz1KFFHnd5oCaTW-t';\n" +
                "</script>\n" +
                "\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/js/history.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/js/lib/conditional/cartScroll.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/js/lib/conditional/minicart.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/js/core.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/xpl.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/xpl.product.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/xpl.search.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/xpl.document.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/templates.xpl.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/templates.xpl.product.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/templates.xpl.search.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng/templates.xpl.document.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng-new/inline.bundle.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng-new/polyfills.bundle.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng-new/vendor.bundle.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/ng-new/main.bundle.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/js/ads.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t<script type=\"text/javascript\" src='/assets/dist/js/master.js?cv=20190212_000002' charset=\"utf-8\"></script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script>\n" +
                "\n" +
                "j$('document').ready(function(){\n" +
                "\tif (Cookies.get('legacyUserName')) {\n" +
                "\t\tif (IBP_WS_ENABLED_FLAG){\n" +
                "\t\t\tModal.refreshLegacyAccountTransition('/xpl/mwLegacyAccountTransition.jsp');\n" +
                "\t\t}\n" +
                "\t}\n" +
                "});\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</g:compress>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script>\n" +
                "\t// Get/Set XPL namespace.\n" +
                "\twindow.xpl = window.xpl || {};\n" +
                "\t\n" +
                "\t// Set constants/application properties.\n" +
                "\txpl.properties = { \n" +
                "\t\t\tcollabratec: { \n" +
                "\t\t\t\t\turl: 'https://ieee-collabratec.ieee.org/app/library'\n" +
                "\t\t\t}\n" +
                "\t};\n" +
                "\t\n" +
                "\txpl.properties.details = {\n" +
                "\t\t\toqs: ''\n" +
                "\t};\n" +
                "</script>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t<!--Begin Optional Configuration-->\n" +
                "\t<script type=\"text/javascript\" src='https://www.ieee.org/ieee-mashup/js/common/jquery.json-2.2.min.js'></script>\n" +
                "\t<script type=\"text/javascript\" src=\"https://www.ieee.org/ieee-mashup/js/common/postmessage-min.js\" ></script>\n" +
                "\t<script type=\"text/javascript\" src='https://www.ieee.org/ieee-mashup/js/common/jquery.cookie-min.js'></script>\n" +
                "\t<script type=\"text/javascript\" src=\"https://www.ieee.org/ieee-mashup/js/auth/ieee-auth-constants-min.js\"></script>\n" +
                "\t<script type=\"text/javascript\" src=\"https://www.ieee.org/ieee-mashup/js/auth/ieee-auth-include-min.js\" ></script>\n" +
                "\t<script type=\"text/javascript\" src='https://www.ieee.org/ieee-mashup/js/minicart/ieee-mini-cart-constants-min.js'></script>\n" +
                "\n" +
                "\n" +
                "\t<script type=\"text/javascript\" src='https://www.ieee.org/ieee-mashup/js/minicart/ieee-mashup-util-min.js'></script>\n" +
                "\t<script type=\"text/javascript\" src=\"https://www.ieee.org/ieee-mashup/js/common/jquery.ba-jqmq-min.js\"></script>\n" +
                "\t<script type=\"text/javaScript\" src=\"https://www.ieee.org/ieee-mashup/js/minicart/ieee-minicart-include-min.js\"> </script>\n" +
                "\n" +
                "\t<!--End Optional Configuration-->\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<!-- Removed due to network issues when loading in China -->\n" +
                "<!-- <script type=\"text/javascript\" src=\"http://s7.addthis.com/js/250/addthis_widget.js#pubid=ra-5005a435228f9245\" async=\"async\"></script>-->\n" +
                "\n" +
                "<!-- Load Mathjax and process the document for Mathjax characters -->\n" +
                "\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/xploreAssets/MathJax-274/MathJax.js?config=default\"></script>\n" +
                "\n" +
                "\n" +
                "<script defer>\n" +
                "\tMathJax.Hub.Queue([\"Typeset\", MathJax.Hub, document.body]);\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\n" +
                "\t\t\t\t<script>\n" +
                "\t\t\t\t\t// set $ alias back to jQuery because noConflict mode is used in legacy pages\n" +
                "\t\t\t\t\twindow.$ = jQuery;\n" +
                "\t\t\t\t</script>\n" +
                "\t\t\t\n" +
                "\t\t</div><!-- /#LayoutWrapper -->\n" +
                "\t</body>\n" +
                "</html>";
        String regex = "global.document.metadata=(.*?);";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            String metadata = m.group(1);
            System.out.println(metadata);
        }
    }
}
