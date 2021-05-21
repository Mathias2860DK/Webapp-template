<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="formbuilder-block">
            <div class="row">
                <div class="col-md-12">
                    <form method="post" class="ng-pristine ng-valid">
                        <div id="table" class="form-horizontal col-md-12 col-xs-12">
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
            <span>
            Ønsket carport mål:
            </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="Carport bredde" for="Input_864110810">
                                        Carport bredde
                                    </label>
                                    <select class="form-control" name="carport_width" title="carport width">
                                        <option selected="selected" value="">Vælg bredde</option>
                                        <option value="240">240 cm</option>
                                        <option value="270">270 cm</option>
                                        <option value="300">300 cm</option>
                                        <option value="330">330 cm</option>
                                        <option value="360">360 cm</option>
                                        <option value="390">390 cm</option>
                                        <option value="420">420 cm</option>
                                        <option value="450">450 cm</option>
                                        <option value="480">480 cm</option>
                                        <option value="510">510 cm</option>
                                        <option value="540">540 cm</option>
                                        <option value="570">570 cm</option>
                                        <option value="600">600 cm</option>
                                        <option value="630">630 cm</option>
                                        <option value="660">660 cm</option>
                                        <option value="690">690 cm</option>
                                        <option value="720">720 cm</option>
                                        <option value="750">750 cm</option>
                                        <!--Skal hentes fra db -->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="carport length" for="carport_length_options">
                                        Carport længde
                                    </label>
                                    <select class="form-control" id="carport_length_options" name="carport_length"
                                            title="carport length">
                                        <option selected="selected" value="">Vælg længde</option>
                                        <option value="240">240 cm</option>
                                        <option value="270">270 cm</option>
                                        <option value="300">300 cm</option>
                                        <option value="330">330 cm</option>
                                        <option value="360">360 cm</option>
                                        <option value="390">390 cm</option>
                                        <option value="420">420 cm</option>
                                        <option value="450">450 cm</option>
                                        <option value="480">480 cm</option>
                                        <option value="510">510 cm</option>
                                        <option value="540">540 cm</option>
                                        <option value="570">570 cm</option>
                                        <option value="600">600 cm</option>
                                        <option value="630">630 cm</option>
                                        <option value="660">660 cm</option>
                                        <option value="690">690 cm</option>
                                        <option value="720">720 cm</option>
                                        <option value="750">750 cm</option>
                                        <option value="780">780 cm</option>
                                    </select>
                                    <!--Skal hentes fra db -->

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="rooftype/colors" for="rooftype_options">
                                        Tag
                                    </label>
                                    <select class="form-control" id="rooftype_options" name="roof"
                                            title="rooftype/colors">
                                        <option selected="selected" value="">Vælg tagtype/farve</option>

                                        <c:forEach var="roof_type" items="${applicationScope.roofTypeList}">
                                            <option value="${roof_type.toString()}">${roof_type.toString()}</option>

                                        </c:forEach>
                                    </select>
                                    <!--Skal hentes fra db -->
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
            <span>
            <b>
            Redskabsrum:
            </b>
            <br>
            NB! Der kan vælges mellem fuld bredde eller halv bredde i forhold til carportens mål.
            </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">


                                    <label title="shed size" for="shed-size">
                                        Redskabsrum størrelse
                                    </label>
                                    <select class="form-control" id="shed-size" name="shed-size" title="shed size">
                                        <option selected="selected" value="no-shed">Ønsker ikke redskabsrum</option>
                                        <option value="halfSize">Halv længde</option>
                                        <option value="fullSize">Fuld længde</option>
                                    </select>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
                                    <hr>
                                </div>

                                <div class="col-md-6 col-xs-12">
                                    <c:if test="${requestScope.error != null}">
                                        <p style="color: red">${requestScope.error}</p>
                                    </c:if>

                    <button name="showSvg" formaction="${pageContext.request.contextPath}/fc/showsvgcommand">Vis tegning</button>
                    <button name="submitRequest" formaction="${pageContext.request.contextPath}/fc/customizecarport">Send forespørgsel</button>
                    </form>

                                    <c:if test="${requestScope.svgdrawing != null}">
                                        ${requestScope.svgdrawing}
                                    </c:if>
                                </div>







            </div>
        </div>


        </div>

    </jsp:body>
</t:genericpage>