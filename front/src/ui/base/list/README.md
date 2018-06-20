# Vou dar a letra

# BaseList
```
super({
  pageTitle: 'Foo',
  listTitle: 'Bar,
  searchPlaceholder: 'Baz',
  searchAction: filterText => this.onSearchTextChanged(filterText),
  thead: () => this.onThead(),
  tbody: (object, key) => this.onTbody(object, key),
  tfoot: () => this.onTfoot(),
  listActions: () => this.onActions()
})
```

* `pageTitle(required)` é o título da página (lista) que será gerado.
* `listTitle(required)` titulo da lista.
* `searchPlaceholder(optional)` placeholder do searchBar que vem por padrão na lista (se não passar nada o padrão é `Pesquisar...`).
* `searchAction` essa é uma function que é retornada pela própria `BaseList` e seu returno é o texto pesquisado no momento. (se não setar essa action, não irá aparecer o searchBar).
* `listActions` se você tiver a necessidade de ter alguns botões sobre a `BaseList` ao lado do `SearchBar` essa é a hora.

* `setObjects` esse cara aqui é importante, a `BaseList` cuida de tudo pra você porem você tem que alimenta-la. E essa é a forma... esse `setObjects` irá fazer com que a lista se atualize e funcione.

# table

Por ser uma lista genérica a `BaseList` já implementa uma table para você,  mas é claro que você precisa informar algumas coisas para que isso acontessa.

* `thead` você deve informar qual o header que quer que a `BaseList` renderize.

Exemplo:

```
<tr>
  <th>Cliente</th>
  <th>Campanha</th>
  <th>Status</th>
  <th className="list__content__table-action">Ações</th>
</tr>
```

* `tbody` você deve informar qual o body que quer que a `BaseList` renderize.

Exemplo:

```
<tr key={key}>
  <td>{ object.name }</td>
  <td>{ object.campaign }</td>
  <td>
    <AmActiveTag isActive={object.active} />
  </td>
  <td className="list__content__table-action">
    <AmButton variants="button--icon-table">{ AmImage.ICONS.Power }</AmButton>
    <AmButton variants="button--icon-table">{ AmImage.ICONS.Delete }</AmButton>
  </td>
</tr>
```

* `tfoot` você deve informar qual o footer que quer que a `BaseList` renderize.
*
Exemplo:

```
<tr>
  <td colSpan="4">Mostrando { this.state.filteredClients.length } de { this.state.clients.length } registros</td>
</tr>
```


# template

Você pode mandar um template da forma que você acha melhor também.

Exemplo:

```
return super.render(
      <table>
        <thead>
          <tr>
            <th>Cliente</th>
            <th>Campanha</th>
            <th>Status</th>
            <th className="list__content__table-action">Ações</th>
          </tr>
        </thead>

        <tbody>
          { this.renderClients() }
        </tbody>

        <tfoot>
          <tr>
            <td colSpan="4">Mostrando { this.state.filteredClients.length } de { this.state.clients.length } registros</td>
          </tr>
        </tfoot>
      </table>

```




# QUALQUER DÚVIDA ENTRE EM /PAGES/LIST/INDEX.JS E LEIA O CÓDIGO :P
