
			<table>
				<thead>
					<tr>
					
						<th><g:message code="menu.sequencia.label" default="Sequencia" /></th>
						<th><g:message code="menu.item.label" default="Item" /></th>
						<g:sortableColumn property="descricaoestab" title="${message(code: 'menu.descricaoestab.label', default: 'Descricaoestab')}" />
						<g:sortableColumn property="preco" title="${message(code: 'menu.preco.label', default: 'Preco')}" />
						<th><g:message code="menu.grupoAdicionais.label" default="Grupo Adicionais" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${menuInstanceList}" status="i" var="menuInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: menuInstance, field: "sequencia")}</td>
						<td><g:link action="show" id="${menuInstance.id}">${fieldValue(bean: menuInstance, field: "item")}</g:link></td>
						<td>${fieldValue(bean: menuInstance, field: "descricaoestab")}</td>
						<td><g:formatNumber number="${menuInstance.preco}" type="currency" /></td>
						<td>${fieldValue(bean: menuInstance, field: "grupoAdicionais")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${menuInstanceTotal}" />
			</div>
		