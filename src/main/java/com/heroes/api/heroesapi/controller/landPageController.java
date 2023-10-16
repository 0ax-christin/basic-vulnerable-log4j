package com.heroes.api.heroesapi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class landPageController {
    
    @RequestMapping("/")
    public String welcome() {
        return "<h1>index</h1>";
    }
	@GetMapping("/docs")
	public String docs()
	{
		return "<html><head><meta charset=\"utf-8\"/><style>h1 { margin: 5px 0 20px 0; }h2, h3 { margin: 10px 0 15px 0; }img { max-width: 100%; }pre { background-color: #f1f1f1; border-radius: 5px; padding: 10px; }pre > code { padding: 0; }table {border-spacing: 0; border-style: solid; border-width: 1px; border-collapse: collapse; margin-top: 0.5em;}th, td {padding: 2px 5px;}a { color: #FF9137; text-decoration: none; } pre, code { font-family: monospace; font-weight: normal;  }pre { display: block; background-color: #f1f1f1; white-space: pre-wrap } code { padding: 3px; overflow: auto; line-height: 1.45em; background-color: #f1f1f1; border-radius: 5px; color: #000000; } .code-comment { color: #75715E;} .code-string { color: #E6DB74;} .code-literal { color: #AE81FF;} .code-type { color: #66D9EF;} .code-builtin { color: #A6E22E;} .code-keyword { color: #F92672;} .code-other { color: #F92672;} body { font-family: Sans; font-weight: normal; font-size: 14pt; } </style></head><body class=\"export\"><h1>API Documentation for QWERTY Store</h1>\n" + //
		        "<h2><code>/heroes</code> endpoint</h2>\n" + //
		        "<h3>Hero Object</h3>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>Attribute</th>\n" + //
		        "<th>Type</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>id</td>\n" + //
		        "<td>int</td>\n" + //
		        "</tr>\n" + //
		        "<tr>\n" + //
		        "<td>name</td>\n" + //
		        "<td>string</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h3><code>GET /heroes/{id}</code> - Get a specific hero</h3>\n" + //
		        "<p>Responds to the GET request for a Hero for the given id</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>param</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>id</td>\n" + //
		        "<td>The id used to locate the Hero</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h4>Return value</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>Hero object and HTTP status of OK if found</p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of NOT_FOUND if not found</p>\n" + //
		        "<p>OR:</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>GET /heroes/1</code> - Gets hero of ID 1</p>\n" + //
		        "<h3><code>GET /heroes</code> - Get all heroes</h3>\n" + //
		        "<p>Responds to the GET request for all Heroes</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>Request Header</th>\n" + //
		        "<th>Type</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>X-Api-Version</td>\n" + //
		        "<td>A number that is either 1.0 or 2.0 is supplied</td>\n" + //
		        "<td>Indicates API version to use.</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<p>Newer API version has more functionality and a revamped design from an architecture point of view. 1.0 has been kept available to customers for backwards compatibility</p>\n" + //
		        "<h4>Return Values</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>Array of Hero objects (may be empty) and HTTP status of OK<br></p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>GET http://localhost:8080/heroes</code></p>\n" + //
		        "<p>Request Headers:</p>\n" + //
		        "<pre><code>X-Api-Version:1.0</code></pre>\n" + //
		        "<h3><code>GET /heroes/?name=&lt;hero-name&gt;</code> - Search for a Hero</h3>\n" + //
		        "<p>Responds to the GET request for all heroes whose name contains the text in name</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>param</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>name</td>\n" + //
		        "<td>The name parameter which contains the text used to find the heroes</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h4>Return values</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>Array of Hero objects whose name matches the text in the user input with HTTP Status of OK 200</p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR 500 otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p>Find all heroes that contain the text &quot;ma&quot;\n" + //
		        "<code>GET http://localhost:8080/heroes/?name=ma</code></p>\n" + //
		        "<h3><code>POST /heroes</code> - Create a Hero</h3>\n" + //
		        "<p>Creates a Hero with the provided hero object</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>param</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>hero</td>\n" + //
		        "<td>The hero to create</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h4>Return value</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>Created Hero object and HTTP status of CREATED</p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of CONFLICT if Hero object already exists <br>\n" + //
		        "Or:</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>POST http://localhost:8080/heroes</code></p>\n" + //
		        "<p>Request Body:</p>\n" + //
		        "<pre><code>{\n" + //
		        "    &quot;id&quot;:3,\n" + //
		        "    &quot;name&quot;:&quot;New Hero&quot;\n" + //
		        "}</code></pre>\n" + //
		        "<h3><code>PUT /heroes</code> - Update a Hero</h3>\n" + //
		        "<p>Updates an existing hero with the provided hero object containing updated values, if it exists</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>param</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>hero</td>\n" + //
		        "<td>The hero to update</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h4>Return value</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>Hero object and HTTP status of OK if updated<br></p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of NOT_FOUND if not found<br></p>\n" + //
		        "<p>OR</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>PUT http://localhost:8080/heroes</code>\n" + //
		        "Body:</p>\n" + //
		        "<pre><code>{\n" + //
		        "    &quot;id&quot;:1,\n" + //
		        "    &quot;name&quot;:&quot;Mr Superhero&quot;\n" + //
		        "}</code></pre>\n" + //
		        "<h3><code>DELETE /heroes/{id}</code> - Delete a Hero</h3>\n" + //
		        "<p>Deletes a Hero with the given id</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>param</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>id</td>\n" + //
		        "<td>The id of the Hero to be deleted</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h4>Return value</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>HTTP status of OK if deleted<br></p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of NOT_FOUND if not found<br></p>\n" + //
		        "<p>OR</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>DELETE http://localhost:8080/heroes/1</code> - Deletes hero of ID 1</p>\n" + //
		        "<h2><code>/products</code> endpoint</h2>\n" + //
		        "<h3>Product Object</h3>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>Attribute</th>\n" + //
		        "<th>Type</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>ProductID</td>\n" + //
		        "<td>int</td>\n" + //
		        "</tr>\n" + //
		        "<tr>\n" + //
		        "<td>ProductName</td>\n" + //
		        "<td>String</td>\n" + //
		        "</tr>\n" + //
		        "<tr>\n" + //
		        "<td>Price</td>\n" + //
		        "<td>String</td>\n" + //
		        "</tr>\n" + //
		        "<tr>\n" + //
		        "<td>Stock</td>\n" + //
		        "<td>String</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<h3><code>GET /products</code> - Get all Products</h3>\n" + //
		        "<p>Responds to GET request with a list of all products available in the database</p>\n" + //
		        "<h4>Return values</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>An array of Product objects (may be empty) and HTTP status of OK</p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>GET http://localhost:8080/products</code></p>\n" + //
		        "<h3><code>GET /product?id=&lt;product-id&gt;</code> - Get a particular product</h3>\n" + //
		        "<p>Responds to GET request supplied with a product ID with a particular product with that specific productID in the database</p>\n" + //
		        "<table>\n" + //
		        "<thead>\n" + //
		        "<tr>\n" + //
		        "<th>param</th>\n" + //
		        "<th>Description</th>\n" + //
		        "</tr>\n" + //
		        "</thead>\n" + //
		        "<tbody>\n" + //
		        "<tr>\n" + //
		        "<td>id</td>\n" + //
		        "<td>The id of the Product to be retrieved</td>\n" + //
		        "</tr>\n" + //
		        "</tbody>\n" + //
		        "</table>\n" + //
		        "<p>Note: Our static analysis revealed an SQL injection is possible in the id parameter due to improper implementation. Must reimplement code with parametrized SQL</p>\n" + //
		        "<h4>Return value</h4>\n" + //
		        "<p>Success:</p>\n" + //
		        "<p>HTTP status of OK with Product object in Response in JSON</p>\n" + //
		        "<p>Failure:</p>\n" + //
		        "<p>HTTP status of NOT_FOUND if not found</p>\n" + //
		        "<p>OR</p>\n" + //
		        "<p>HTTP status of INTERNAL_SERVER_ERROR otherwise</p>\n" + //
		        "<h4>Example</h4>\n" + //
		        "<p><code>GET http://localhost:8080/product?id=1</code></p>\n" + //
		        "</body></html>";
	}
}
    