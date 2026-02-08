#!/usr/bin/env bash
# Downloads globe.gl from npm.
# Run this before building if the JS bundle is not already present.
#
# Source: globe.gl v2.45.0 — MIT license — https://github.com/vasturiano/globe.gl
# Note: earth-blue-marble.jpg (public domain, NASA) is committed to the repo.
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ASSETS_DIR="$SCRIPT_DIR/../app/src/main/assets/globe"

GLOBE_GL_VERSION="2.45.0"
GLOBE_GL_SHA256="1e95489a5b90460aba5acdab088c2d0efaec48b6dd97d42136dc9795ce93dc5b"
GLOBE_GL_URL="https://registry.npmjs.org/globe.gl/-/globe.gl-${GLOBE_GL_VERSION}.tgz"

mkdir -p "$ASSETS_DIR"

verify_sha256() {
    local file="$1" expected="$2"
    local actual
    if command -v sha256sum > /dev/null 2>&1; then
        actual="$(sha256sum "$file" | awk '{print $1}')"
    else
        actual="$(shasum -a 256 "$file" | awk '{print $1}')"
    fi
    if [ "$actual" != "$expected" ]; then
        echo "ERROR: SHA-256 mismatch for $file"
        echo "  expected: $expected"
        echo "  actual:   $actual"
        rm -f "$file"
        exit 1
    fi
}

if [ -f "$ASSETS_DIR/globe.gl.min.js" ]; then
    echo "globe.gl.min.js already present, verifying checksum..."
    verify_sha256 "$ASSETS_DIR/globe.gl.min.js" "$GLOBE_GL_SHA256"
    echo "  OK"
else
    echo "Downloading globe.gl v${GLOBE_GL_VERSION} from npm..."
    TMPDIR="$(mktemp -d)"
    curl -sL "$GLOBE_GL_URL" -o "$TMPDIR/globe.gl.tgz"
    tar xzf "$TMPDIR/globe.gl.tgz" -C "$TMPDIR" package/dist/globe.gl.min.js
    mv "$TMPDIR/package/dist/globe.gl.min.js" "$ASSETS_DIR/globe.gl.min.js"
    rm -rf "$TMPDIR"
    verify_sha256 "$ASSETS_DIR/globe.gl.min.js" "$GLOBE_GL_SHA256"
    echo "  OK — saved to assets/globe/globe.gl.min.js"
fi

echo "All globe assets are ready."
