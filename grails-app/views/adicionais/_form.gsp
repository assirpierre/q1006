<%@ page import="qmw.Adicionais" %>



<div class="fieldcontain ${hasErrors(bean: adicionaisInstance, field: 'grupoAdicionais', 'error')} required">
	<label for="grupoAdicionais">
		<g:message code="adicionais.grupoAdicionais.label" default="Grupo Adicionais" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="grupoAdicionais" name="grupoAdicionais.id" from="${qmw.GrupoAdicionais.findAllByEstab(session.estab)}" optionKey="id" required="" value="${adicionaisInstance?.grupoAdicionais?.id}" class="many-to-one" noSelection="['': '']"/>
    <g:helpBalloon code="adicionais.grupoAdicionais.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adicionaisInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="adicionais.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${qmw.Item.findAllByTipo("Produto")}" optionKey="id" required="" value="${adicionaisInstance?.item?.id}" class="many-to-one" noSelection="['': '']"/>
    <g:helpBalloon code="adicionais.item.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adicionaisInstance, field: 'descricaoestab', 'error')} ">
	<label for="descricaoestab">
		<g:message code="adicionais.descricaoestab.label" default="Descricaoestab" />
		
	</label>
	<g:textField name="descricaoestab" size="70" maxlength="300" value="${adicionaisInstance?.descricaoestab}"/>
    <g:helpBalloon code="adicionais.descricaoestab.label"/>
</div>

<div class="fieldcontain ${hasErrors(bean: adicionaisInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="adicionais.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>	
	<g:field name="preco" value="${fieldValue(bean: adicionaisInstance, field: 'preco')}" required=""/>
    <g:helpBalloon code="adicionais.preco.label"/>
</div>

