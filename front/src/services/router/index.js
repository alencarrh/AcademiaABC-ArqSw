import {
  ProdutoList,
  ProdutoForm,
  FornecedorList,
  FornecedorForm,
  UsuarioList,
  UsuarioForm
} from 'am-pages'

export class AmRouter {
  static ROUTES = [
    {
      name: 'Produtos',
      path: '/produto',
      icon: 'Gift',
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
    },
    {
      name: 'Fornecedores',
      path: '/fornecedor',
      icon: 'Projects',
      exact: true,
      component: FornecedorList
    },
    {
      hideOnMenu: true,
      name: 'Cadastro de Fornecedor',
      path: '/fornecedor/new',
      exact: true,
      component: FornecedorForm
    },
    {
      hideOnMenu: true,
      name: 'Edição de Fornecedor',
      path: '/fornecedor/edit',
      exact: true,
      component: FornecedorForm
    },
    {
      name: 'Usuários',
      path: '/usuario',
      icon: 'User',
      exact: true,
      component: UsuarioList
    },
    {
      hideOnMenu: true,
      name: 'Cadastro de Usuário',
      path: '/usuario/new',
      exact: true,
      component: UsuarioForm
    },
    {
      hideOnMenu: true,
      name: 'Edição de Usuário',
      path: '/usuario/edit',
      exact: true,
      component: UsuarioForm
    }
  ]
}
