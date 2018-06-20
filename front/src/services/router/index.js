import {
  ProdutoList,
  ProdutoForm,
} from 'am-pages'

export class AmRouter {
  static ROUTES = [
    {
      name: 'Produtos',
      path: '/produto',
      icon: 'Projects',
      exact: true,
      component: ProdutoList
    },
    {
      hideOnMenu: true,
      name: 'Cadastro de Produto',
      path: '/produto/new',
      exact: true,
      component: ProdutoForm
    },
    {
      hideOnMenu: true,
      name: 'Edição de Produto',
      path: '/produto/edit',
      exact: true,
      component: ProdutoForm
    }
  ]
}
