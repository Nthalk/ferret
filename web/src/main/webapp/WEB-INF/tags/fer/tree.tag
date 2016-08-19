<%@ tag description="Tree" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="value" type="com.iodesystems.ferret.services.NavNode" %>

<c:choose>
    <c:when test="${value.type == 'root'}">
        <style>
            .navTree {
                border: 1px solid #e7e7e7;
                border-top: 0;
                margin-top: -20px;
                display: inline-block;
            }

            .navTree .header {
                background-color: rgba(207, 207, 207, 0.65);
                border-bottom: 1px solid #cfcfcf;
                font-weight: bolder;
            }

            .navTree .header.search {
                font-weight: normal;;
            }

            .navTree ul, .navTree li {
                list-style: none;
                margin: 0;
                padding: 0;
            }

            .navTree li, .navTree .header {
                padding: 10px;
            }

        </style>
        <div class="navTree">
            <div class="header search">
                <input class="form-control search" placeholder="Search"/>
            </div>
            <div class="header">
                DataSources
                <a class="btn btn-success btn-xs pull-right"><i class="fa fa-plus fa-1"></i></a>
            </div>
            <ul>
                <c:forEach var="child" items="${value.children}">
                    <li><i class="fa fa-database fa-1" aria-hidden="true"></i> ${child.label}</li>
                </c:forEach>
            </ul>
        </div>
    </c:when>
</c:choose>


