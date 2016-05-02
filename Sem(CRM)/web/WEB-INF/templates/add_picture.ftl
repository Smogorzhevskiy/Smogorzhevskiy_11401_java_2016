<#include "main-template.ftl"/>
<#macro m_body>
                <h3>Add picture </h3>
                    <#if error??>
                            <strong>Oh snap!</strong> Change a few things up and try submitting again.
                    </#if>
                    <form role="form" action="/artist/add_picture" method="post">
                            <label>Name</label>
                            <input class="form-control" placeholder="Enter book name" type="text" name="name" required autofocus>
                            <label>Author</label>
                            <input class="form-control" placeholder="Enter author" type="text" name="author" required>
                            <label>Description</label>
                            <textarea class="form-control" rows="3" placeholder="Short description" name="description" required></textarea>
                            <label>Price</label>
                            <input class="form-control" placeholder="Enter price" type="number" name="price" required>
                        <button type="submit" class="btn btn-default">Add</button>
                    </form>
</#macro>
<@main title="Add picture"/>