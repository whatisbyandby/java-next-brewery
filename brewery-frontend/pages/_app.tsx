import '../styles/globals.css';
import type { AppProps } from 'next/app';
import { ChakraProvider } from '@chakra-ui/react';
import Page from '../components/Page';
import theme from '../theme';

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <ChakraProvider theme={theme}>
      <Page>
        <Component {...pageProps} />
      </Page>
    </ChakraProvider>
  );
}

export default MyApp;
