<%@ page import="qmw.Menu" %>



<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'menuPrincipal', 'error')} required">
	<label for="menuPrincipal">
		<g:message code="menu.menuPrincipal.label" default="Menu Principal" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="menuPrincipal" name="menuPrincipal.id" from="${qmw.MenuPrincipal.findAllByEstab(session.estab)}" optionKey="id" required="" value="${menuInstance?.menuPrincipal?.id}" class="many-to-one" noSelection="['': '']"/>
    <g:helpBalloon code="menu.menuPrincipal.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="menu.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${qmw.Item.findAllByTipoAndAprovado("Produto", true)}" optionKey="id" required="" value="${menuInstance?.item?.id}" class="many-to-one" noSelection="['': '']"/>
    <g:helpBalloon code="menu.item.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'descricaoestab', 'error')} ">
	<label for="descricaoestab">
		<g:message code="menu.descricaoestab.label" default="Descricaoestab" />
		
	</label>
	<g:textField name="descricaoestab" size="70" maxlength="300" value="${adicionaisInstance?.descricaoestab}"/>
    <g:helpBalloon code="menu.descricaoestab.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="menu.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preco" value="${fieldValue(bean: menuInstance, field: 'preco')}"></g:field>
    <g:helpBalloon code="menu.preco.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'grupoAdicionais', 'error')}">
	<label for="grupoAdicionais">
		<g:message code="menu.grupoAdicionais.label" default="Grupo Adicionais" />

	</label>
	<g:select id="grupoAdicionais" name="grupoAdicionais.id" from="${qmw.GrupoAdicionais.findAllByEstab(session.estab)}" optionKey="id" value="${menuInstance?.grupoAdicionais?.id}" noSelection="['': '']"/>
    <g:helpBalloon code="menu.grupoAdicionais.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'sequencia', 'error')} required">
	<label for="sequencia">
		<g:message code="menu.sequencia.label" default="Sequencia" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="sequencia" type="number" value="${menuInstance.sequencia}" required=""/>
    <g:helpBalloon code="menu.sequencia.label"/>
</div>

